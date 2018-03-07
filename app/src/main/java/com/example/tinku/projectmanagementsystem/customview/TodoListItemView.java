//package com.example.tinku.projectmanagementsystem.customview;
//
//import android.content.Context;
//import android.graphics.Canvas;
//import android.graphics.Paint;
//import android.util.AttributeSet;
//
//
///**
// * Created by ryellap on 3/7/18.
// */
//public class TodoListItemView extends android.support.v7.widget.AppCompatTextView {
//
//    private Paint marginPaint;
//    private Paint linePaint;
//    private int paperColor;
//    private float margin;
//
//    public TodoListItemView(Context context, AttributeSet ats, int ds) {
//        super(context, ats, ds);
//        init();
//    }
//
//    public TodoListItemView(Context context) {
//        super(context);
//        init();
//    }
//
//    public TodoListItemView(Context context, AttributeSet attrs) {
//        super(context, attrs);
//        init();
//    }
//
//
//    @Override
//    public void onDraw(Canvas canvas) {
//// Use the base TextView to render the text.
//
//        // Color as pap
//        canvas.drawColor(paperColor);
//// Draw ruled lines
//
//        canvas.drawLine(0, 0, getMeasuredHeight(), 0, linePaint);
//        canvas.drawLine(0, getMeasuredHeight(),
//                getMeasuredWidth(), getMeasuredHeight(), linePaint);
//// Draw margin
//        canvas.drawLine(margin, 0, margin, getMeasuredHeight(), marginPaint);
//// Move the text across from the margin canvas.save();
//        canvas.translate(margin, 0);
//// Use the TextView to render the text. super.onDraw(canvas);
//        canvas.restore();
//    }
//
//
//    private void init() {
//// Get a reference to our resource table. Resources myResources = getResources();
//// Create the paint brushes we will use in the onDraw method. marginPaint = new Paint(Paint.ANTI_ALIAS_FLAG); marginPaint.setColor(myResources.getColor(R.color.notepad_margin)); linePaint = new Paint(Paint.ANTI_ALIAS_FLAG); linePaint.setColor(myResources.getColor(R.color.notepad_lines));
//// Get the paper background color and the margin width. paperColor = myResources.getColor(R.color.notepad_paper); margin = myResources.getDimension(R.dimen.notepad_margin);
//    }
//
//
//}