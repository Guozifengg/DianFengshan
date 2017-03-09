package guozifeng.bwei.com.dianfengshan;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * 姓名：郭子锋
 * Created by Administrator on 2017/3/9.
 * 作用：
 */
public class CustomView extends View {
    private Paint paint=new Paint();
    private MyThread thread;
    private float a1=0;
    private float b1=90;
    private float c1=180;
    private float d1=270;
    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF1=new RectF(0,0,100,100);
//        RectF rectF2=new RectF(0,0,100,100);
        paint.setAntiAlias(true);

        canvas.drawArc(rectF1,a1,30,true,paint);
        canvas.drawArc(rectF1,b1,30,true,paint);
        canvas.drawArc(rectF1,c1,30,true,paint);
        canvas.drawArc(rectF1,d1,30,true,paint);

        canvas.drawLine(100,100,200,200,paint);

        if(thread==null){
            thread=new MyThread();
            thread.start();
        }
    }

    //创建线程
    class MyThread extends Thread{
        Random random=new Random();
        @Override
        public void run() {
            super.run();
            while (true){
                a1+=4;b1+=4;c1+=4;d1+=4;
                int r=random.nextInt(256);
                int g=random.nextInt(256);
                int b=random.nextInt(256);
                paint.setARGB(255,r,g,b);
                postInvalidate();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
