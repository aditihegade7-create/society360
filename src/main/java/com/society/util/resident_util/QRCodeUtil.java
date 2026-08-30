package com.society.util.resident_util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class QRCodeUtil {










        
    private QRCodeUtil() {
    }

    public static Path generateQRCode(
            String data,
            String fileName
    ) throws Exception {

        int width = 400;
        int height = 400;

        Map<EncodeHintType, Object> hints =
                new HashMap<>();

        hints.put(
                EncodeHintType.MARGIN,
                2
        );

        BitMatrix matrix =
                new MultiFormatWriter().encode(
                        data,
                        BarcodeFormat.QR_CODE,
                        width,
                        height,
                        hints
                );

        Path qrFolder =
                Path.of(
                        System.getProperty("user.home"),
                        "Society360",
                        "QR"
                );

        Files.createDirectories(
                qrFolder
        );

        Path qrFile =
                qrFolder.resolve(fileName);

        MatrixToImageWriter.writeToPath(
                matrix,
                "PNG",
                qrFile
        );

        return qrFile;
    }
}
