package com.eye.eyepetizer.until;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

/**
 * Created by dllo on 16/9/2.
 */
public class MyImage {


    /**
     * 获得一张压缩后的图
     * 当原图没有加载进内存的时候,使用
     * 它只能按比例压缩,将宽高都压缩到接近目标宽高的程度
     * 并不能保证能把宽高压缩到要求的宽高
     *
     * @param id   图片的资源id
     * @param reqH 要求的高
     * @param reqW 要求的宽
     * @return 压缩后的图片
     */
//    public Bitmap getSmallBitmap(int id, int reqH, int reqW) {
//        //我们不想先把图片加载进内存再压缩,
//        //就需要先读取一次图片的宽高信息
//        //利用BitmapFactory.Options 这个类
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        //设置它的inJustDecodeBounds属性为true
//        //代表,使用该options来加载图片的时候,只会加载图片的
//        //宽高信息,而不会真的加载图片,比较省内存
//        options.inJustDecodeBounds = true;
//
//        //利用该options加载一次图片
//        BitmapFactory.decodeResource(getResources(), id, options);
//
//        //图片的宽高信息 就会保存在options里
//        //通过outWidth/outHeight 拿到
//        int x = options.outWidth;
//        int y = options.outHeight;
//        //sampleSize 是缩放比例(采样率),
//        //它是一个正整数
//        //代表 图片的宽高都缩小成原尺寸的几分之一
//        int sampleSize = Math.max((x / reqW), (y / reqH));
//        //需要把inJustDecodeBounds 还原为false
//        //来输出图片
//        options.inJustDecodeBounds = false;
//        //设置采样率
//        options.inSampleSize = sampleSize;
//        //设置图片的色彩范围
//        options.inPreferredConfig = Bitmap.Config.RGB_565;
//        //输出图片
//        Bitmap result = BitmapFactory.decodeResource(getResources(), id, options);
//        return result;
//
//    }

    /**
     * 有时,我们只能拿到内存里已有的大图
     * 想要压缩
     *
     * @param bitmap 大图
     * @param reqW
     * @param reqH
     * @return 压缩后的小图
     */
    public Bitmap getSmallBitmap(Bitmap bitmap, int reqW, int reqH) {
        //方法一
        //会把目标Bitmap精确的压缩到 指定宽高
        //但是,会破坏原图的比例,
//        Bitmap result = Bitmap.createScaledBitmap(bitmap,
//                reqW, reqH, false);

        //方法2
        //Matrix 是一个3*3矩阵,保存着图片的各种物理信息
        //可以操作这个矩阵达到,类似旋转,缩放,透视效果等变化
        Matrix matrix = new Matrix();
        //求出缩放比例,当图片做缩放变化的时候
        //会用原图的 宽高 乘 这个比例
        //比例的求法 用 要求宽高 除以 原图宽高 取最小值
        float scale = Math.min((reqW * 1.0f / bitmap.getWidth()),
                reqH * 1.0f / bitmap.getHeight());
        matrix.postScale(scale, scale);

        //注意,如果矩阵的缩放比例 都为1的话,
        //那么 就不会生成新的图片
        //Android 就会把bitmap 当做result 返回
        Bitmap result = Bitmap.createBitmap(bitmap
                , 0, 0, bitmap.getWidth(), bitmap.getHeight()
                , matrix, false);

        return result;
    }

}
