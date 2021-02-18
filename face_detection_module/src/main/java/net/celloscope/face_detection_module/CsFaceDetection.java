package net.celloscope.face_detection_module;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.SparseArray;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

public class CsFaceDetection {
    public static int isSingleFaceFound(Context c, String imagePath) {
        FaceDetector detector;
        Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
        int faceCount = 0;
        detector = new com.google.android.gms.vision.face.FaceDetector.Builder(c)
                .setTrackingEnabled(false)
                .setLandmarkType(FaceDetector.ALL_LANDMARKS)
                .setClassificationType(com.google.android.gms.vision.face.FaceDetector.ALL_CLASSIFICATIONS)
                .setMode(FaceDetector.FAST_MODE)
                .build();
        if (detector.isOperational() && bitmap != null) {
            Frame frame = new Frame.Builder().setBitmap(bitmap).build();
            SparseArray<Face> faces = detector.detect(frame);
            faceCount = faces.size();
        }
        detector.release();
        return faceCount;
    }
}
