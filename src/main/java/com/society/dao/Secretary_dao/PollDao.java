package com.society.dao.Secretary_dao;

import java.util.ArrayList;
import java.util.List;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

import com.society.config.FirebaseConfig;
import com.society.dao.Welcome.UserDao;
import com.society.model.Secretary_model.Poll;

public class PollDao {

    // =========================================================
    // FIRESTORE
    // =========================================================

    private final Firestore firestore;

    // =========================================================
    // COLLECTION NAMES
    // =========================================================

    private static final String MAIN_COLLECTION =
            "Polls";

    private static final String SUB_COLLECTION =
            "polls";

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public PollDao() {

        firestore =
                FirebaseConfig.getFirestore();
    }

    // =========================================================
    // GET LOGGED-IN EMAIL
    // =========================================================

    private String getLoggedInEmail() {

        try {

            String email =
                    UserDao.getLoggedInEmail();

            if (email == null
                    || email.trim().isEmpty()) {

                System.out.println(
                        "ERROR: Logged-in email not found."
                );

                return null;
            }

            return email
                    .trim()
                    .toLowerCase();

        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }
    }

    // =========================================================
    // GET POLL COLLECTION
    // =========================================================

    private CollectionReference getPollCollection() {

        String email =
                getLoggedInEmail();

        if (email == null) {
            return null;
        }

        return firestore
                .collection(MAIN_COLLECTION)
                .document(email)
                .collection(SUB_COLLECTION);
    }

    // =========================================================
    // ADD POLL
    // =========================================================

    public boolean addPoll(Poll poll) {

        try {

            if (poll == null) {
                return false;
            }

            String email =
                    getLoggedInEmail();

            if (email == null) {
                return false;
            }

            CollectionReference collection =
                    getPollCollection();

            if (collection == null) {
                return false;
            }

            poll.setCreatedByEmail(email);

            DocumentReference reference =
                    collection.document();

            poll.setPollId(
                    reference.getId()
            );

            reference
                    .set(poll.toMap())
                    .get();

            System.out.println(
                    "========================================"
            );

            System.out.println(
                    "POLL SAVED SUCCESSFULLY"
            );

            System.out.println(
                    "Email: " + email
            );

            System.out.println(
                    "Poll ID: " + poll.getPollId()
            );

            System.out.println(
                    "========================================"
            );

            return true;

        } catch (Exception e) {

            System.out.println(
                    "Error adding poll:"
            );

            e.printStackTrace();

            return false;
        }
    }

    // =========================================================
    // GET ALL POLLS
    // =========================================================

    public List<Poll> getAllPolls() {

        List<Poll> polls =
                new ArrayList<>();

        try {

            CollectionReference collection =
                    getPollCollection();

            if (collection == null) {
                return polls;
            }

            ApiFuture<QuerySnapshot> future =
                    collection.get();

            QuerySnapshot snapshot =
                    future.get();

            for (QueryDocumentSnapshot document :
                    snapshot.getDocuments()) {

                Poll poll =
                        documentToPoll(document);

                if (poll != null) {

                    polls.add(poll);
                }
            }

            System.out.println(
                    "Fetched "
                            + polls.size()
                            + " polls."
            );

        } catch (Exception e) {

            System.out.println(
                    "Error fetching polls:"
            );

            e.printStackTrace();
        }

        return polls;
    }

    // =========================================================
    // GET ACTIVE POLLS
    // =========================================================

    public List<Poll> getActivePolls() {

        List<Poll> result =
                new ArrayList<>();

        for (Poll poll : getAllPolls()) {

            if (poll.getStatus() != null
                    && poll.getStatus()
                    .equalsIgnoreCase("ACTIVE")) {

                result.add(poll);
            }
        }

        return result;
    }

    // =========================================================
    // GET SURVEYS
    // =========================================================

    public List<Poll> getSurveys() {

        List<Poll> result =
                new ArrayList<>();

        for (Poll poll : getAllPolls()) {

            if (poll.getType() != null
                    && poll.getType()
                    .equalsIgnoreCase("Survey")) {

                result.add(poll);
            }
        }

        return result;
    }

    // =========================================================
    // GET CLOSED POLLS
    // =========================================================

    public List<Poll> getHistory() {

        List<Poll> result =
                new ArrayList<>();

        for (Poll poll : getAllPolls()) {

            if (poll.getStatus() != null
                    && poll.getStatus()
                    .equalsIgnoreCase("CLOSED")) {

                result.add(poll);
            }
        }

        return result;
    }

    // =========================================================
    // CLOSE POLL
    // =========================================================

    public boolean closePoll(String pollId) {

        try {

            if (pollId == null
                    || pollId.trim().isEmpty()) {

                return false;
            }

            CollectionReference collection =
                    getPollCollection();

            if (collection == null) {
                return false;
            }

            DocumentReference reference =
                    collection.document(pollId);

            DocumentSnapshot snapshot =
                    reference.get().get();

            if (!snapshot.exists()) {

                System.out.println(
                        "Poll not found: " + pollId
                );

                return false;
            }

            reference
                    .update("status", "CLOSED")
                    .get();

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }

    // =========================================================
    // DELETE POLL
    // =========================================================

    public boolean deletePoll(String pollId) {

        try {

            if (pollId == null
                    || pollId.trim().isEmpty()) {

                return false;
            }

            CollectionReference collection =
                    getPollCollection();

            if (collection == null) {
                return false;
            }

            collection
                    .document(pollId)
                    .delete()
                    .get();

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }

    // =========================================================
    // ADD VOTE
    // =========================================================

    public boolean addVote(
            String pollId,
            int optionIndex) {

        try {

            if (pollId == null
                    || pollId.trim().isEmpty()) {

                return false;
            }

            CollectionReference collection =
                    getPollCollection();

            if (collection == null) {
                return false;
            }

            DocumentReference reference =
                    collection.document(pollId);

            DocumentSnapshot snapshot =
                    reference.get().get();

            if (!snapshot.exists()) {
                return false;
            }

            String status =
                    snapshot.getString("status");

            if (status == null
                    || !status.equalsIgnoreCase("ACTIVE")) {

                return false;
            }

            List<Long> voteCounts =
                    new ArrayList<>();

            List<?> storedVotes =
                    (List<?>) snapshot.get("voteCounts");

            if (storedVotes != null) {

                for (Object value :
                        storedVotes) {

                    if (value instanceof Number) {

                        voteCounts.add(
                                ((Number) value)
                                        .longValue()
                        );

                    } else {

                        voteCounts.add(0L);
                    }
                }
            }

            if (optionIndex < 0
                    || optionIndex >= voteCounts.size()) {

                return false;
            }

            voteCounts.set(
                    optionIndex,
                    voteCounts.get(optionIndex) + 1
            );

            long totalVotes = 0;

            if (snapshot.contains("totalVotes")) {

                Long storedTotal =
                        snapshot.getLong("totalVotes");

                if (storedTotal != null) {

                    totalVotes =
                            storedTotal;
                }
            }

            totalVotes++;

            reference
                    .update(
                            "voteCounts",
                            voteCounts,
                            "totalVotes",
                            totalVotes
                    )
                    .get();

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }

    // =========================================================
    // DOCUMENT -> POLL
    // =========================================================

    private Poll documentToPoll(
            DocumentSnapshot document) {

        try {

            Poll poll =
                    new Poll();

            String pollId =
                    document.getString("pollId");

            if (pollId == null
                    || pollId.isEmpty()) {

                pollId =
                        document.getId();
            }

            poll.setPollId(pollId);

            poll.setQuestion(
                    document.getString("question")
            );

            poll.setType(
                    document.getString("type")
            );

            poll.setDescription(
                    document.getString("description")
            );

            poll.setCreatedDate(
                    document.getString("createdDate")
            );

            poll.setEndDate(
                    document.getString("endDate")
            );

            poll.setTargetAudience(
                    document.getString("targetAudience")
            );

            poll.setStatus(
                    document.getString("status")
            );

            poll.setCreatedByEmail(
                    document.getString("createdByEmail")
            );

            // =====================================================
            // OPTIONS
            // =====================================================

            List<String> options =
                    new ArrayList<>();

            List<?> storedOptions =
                    (List<?>) document.get("options");

            if (storedOptions != null) {

                for (Object value :
                        storedOptions) {

                    if (value != null) {

                        options.add(
                                String.valueOf(value)
                        );
                    }
                }
            }

            poll.setOptions(options);

            // =====================================================
            // VOTE COUNTS
            // =====================================================

            List<Long> voteCounts =
                    new ArrayList<>();

            List<?> storedVotes =
                    (List<?>) document.get("voteCounts");

            if (storedVotes != null) {

                for (Object value :
                        storedVotes) {

                    if (value instanceof Number) {

                        voteCounts.add(
                                ((Number) value)
                                        .longValue()
                        );

                    } else {

                        voteCounts.add(0L);
                    }
                }
            }

            while (voteCounts.size()
                    < options.size()) {

                voteCounts.add(0L);
            }

            poll.setVoteCounts(voteCounts);

            // =====================================================
            // TOTAL
            // =====================================================

            Long totalVotes = null;

            if (document.contains("totalVotes")) {

                totalVotes =
                        document.getLong(
                                "totalVotes"
                        );
            }

            if (totalVotes == null) {

                totalVotes =
                        calculateVotes(
                                voteCounts
                        );
            }

            poll.setTotalVotes(totalVotes);

            return poll;

        } catch (Exception e) {

            e.printStackTrace();

            return null;
        }
    }

    // =========================================================
    // CALCULATE TOTAL VOTES
    // =========================================================

    private long calculateVotes(
            List<Long> voteCounts) {

        long total = 0;

        if (voteCounts == null) {
            return 0;
        }

        for (Long value :
                voteCounts) {

            if (value != null) {

                total += value;
            }
        }

        return total;
    }
}