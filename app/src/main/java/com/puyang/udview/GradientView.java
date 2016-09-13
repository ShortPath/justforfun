package com.puyang.udview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yangpu on 6/13/16.
 */
public class GradientView extends View{
    public GradientView(Context context) {
        super(context);
    }

    public GradientView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GradientView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Path path = new Path();
        path.moveTo(getLeft(), getTop());
        path.lineTo(100f, 100f);
        path.lineTo(100f, 200f);
        path.lineTo(200f, 300f);
        path.lineTo(getRight(), getBottom());
        //path.close();
        /*canvas.drawPath(path, paint);*/

        Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint1.setStyle(Paint.Style.FILL_AND_STROKE);
        paint1.setStrokeWidth(10f);
        paint1.setColor(Color.BLACK);

        //canvas.drawPath(path, paint1);

        //canvas.clipPath(path);
        /*RectF rectF = new RectF();
        rectF.set(20, 20, 500, 500);

        canvas.clipRect(rectF, Region.Op.INTERSECT);*/

        LinearGradient linearGradient = new LinearGradient(getLeft(), getTop(), getLeft(), getBottom(), Color.YELLOW, Color.RED, Shader.TileMode.CLAMP);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setShader(linearGradient);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10f);
        canvas.drawPath(path, paint);
        //canvas.drawRect(getLeft(), getTop(), getRight(), getBottom(), paint);

        canvas.restore();

    }
}
