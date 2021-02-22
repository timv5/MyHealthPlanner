package com.example.myhealthplanner.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.util.Date;

public class HelperUtil {

    public static String formatDate(Date date) {
        return (String) android.text.format.DateFormat.format("dd.MM.yyyy", date);
    }

    public static byte[] convertImage2ByteArray(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 0, stream);
        return stream.toByteArray();
    }

    public static Bitmap convertByteArray2Image(byte[] bytes) {
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }

}
