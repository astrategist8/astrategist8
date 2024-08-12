import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

public class QRCodeScanner {

    public static void main(String[] args) {
        try {
            // Ganti dengan path gambar kode QR
            String imagePath = "path/ke/gambar/kode_qr.jpg";

            // Membaca gambar kode QR
            BufferedImage image = ImageIO.read(new File(imagePath));

            // Memindai kode QR
            String result = scanQRCode(image);

            // Mencetak hasil pemindaian
            System.out.println("Kode QR: " + result);

        } catch (IOException | NotFoundException e) {
            System.err.println("Terjadi kesalahan: " + e.getMessage());
        }
    }

    private static String scanQRCode(BufferedImage image) throws NotFoundException {
        // Membuat objek MultiFormatReader
        MultiFormatReader reader = new MultiFormatReader();

        // Menetapkan petunjuk dekode
        Map<DecodeHintType, Object> hints = new EnumMap<>(DecodeHintType.class);
        hints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        hints.put(DecodeHintType.POSSIBLE_FORMATS, BarcodeFormat.QR_CODE);

        // Membuat objek LuminanceSource dari gambar
        LuminanceSource source = new BufferedImageLuminanceSource(image);

        // Membuat objek BinaryBitmap dari LuminanceSource
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

        // Memindai kode QR
        Result result = reader.decode(bitmap, hints);

        // Mengembalikan hasil pemindaian
        return result.getText();
    }
}
