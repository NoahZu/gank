package noahzu.github.io.gank.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by Administrator on 2016/8/23.
 */
public class TipEditText extends EditText{
    private int mSumCount;//限制总字数
    private int mCurrentCount;//当前字数
    private TextWatcher mTextWatcher;//编辑器监听
    private int mWidth;//宽度
    private int mHeight;//高度
    private Paint mPaint;


    public TipEditText(Context context) {
        this(context,null);
    }

    public TipEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        initView();
    }

    private void initView() {
        mSumCount = 10;
        mCurrentCount = 0;

        mTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                invalidate();
                mCurrentCount = s.length();
                if (mCurrentCount > mSumCount){
                    setText(s.toString().substring(0,s.length()-1));
                    setSelection(getText().length());
                }

            }
        };
        addTextChangedListener(mTextWatcher);
        initPaint();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawTip(canvas);
    }

    /**
     * 初始化画笔
     */
    private void initPaint() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.GRAY);
        mPaint.setTextSize(40);
    }

    /**
     * 画提示还剩多少字的提示
     */
    private void drawTip(Canvas canvas) {
        float x = mWidth - 80;
        float y = mHeight - 50;
        int count = mSumCount - mCurrentCount;
        canvas.drawText(count+"",x,y,mPaint);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.mWidth = w;
        this.mHeight = h;
    }
}
