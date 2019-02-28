package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String SUM = "+",SUBTRACT="-",MULTIPLY ="X",DIVIDE="/",EQUALS="=",DOT=".",T100="%";
    private static final int NUM100=100;
    private TextView mTvContent,mTvResult;
    private String mContent,mresult;
    private Double mValue1,mValue2,mT100;
    private String mSymbolMath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        addControls();



    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.deleteAll:
                mContent="";
                mresult="";
                mTvResult.setText("");
                mTvContent.setText(mContent);
                mValue1=Double.NaN;
                break;
            case R.id.dot:
                mContent+=".";
                mresult+=".";
                mTvResult.setText(mresult);
                mTvContent.setText(mContent);
                break;
            case R.id.negative:
                mContent+=SUBTRACT;
                mresult+=SUBTRACT;
                mTvResult.setText(mresult);
                mTvContent.setText(mContent);
                break;
            case R.id.t100:
                mContent+=T100;
                mTvContent.setText(mContent);
                mresult=mTvResult.getText().toString();
                mT100=Double.parseDouble(mresult)/NUM100;
                mTvResult.setText(mT100.toString());
                break;
            case R.id.div:
                mContent+=DIVIDE;
                math(DIVIDE);
                mSymbolMath=DIVIDE;
                mTvContent.setText(mContent);
                mresult="";
                break;
            case R.id.multiply:
                math(SUBTRACT);
                mSymbolMath=SUBTRACT;
                mContent+=SUBTRACT;
                mTvContent.setText(mContent);
                mresult="";
                break;
            case R.id.subtract:
                math(SUBTRACT);
                mSymbolMath=SUBTRACT;
                mContent+=SUBTRACT;
                mTvContent.setText(mContent);
                mresult="";
                break;
            case R.id.sum:
                math(SUM);
                mSymbolMath=SUM;
                mContent+=SUM;
                mTvContent.setText(mContent);
                mresult="";
                break;
            case R.id.equals:
                math(mSymbolMath);
                mTvResult.setText(mValue1.toString());
                mSymbolMath="";
                break;

            default:
                if(mTvResult.getText()==SUBTRACT)
                    mresult+=SUBTRACT;
                mContent= mContent+ ((Button) view).getText();
                mresult+=((Button) view).getText();
                mTvContent.setText(mContent);
                mTvResult.setText(mresult);
                break;
        }
    }




    public void addControls(){
        int[] idButtons={
                R.id.num0,R.id.num1,R.id.num2,R.id.num3,R.id.num4,R.id.num5,R.id.num6,R.id.num7,R.id.num8,
                R.id.num9,R.id.deleteAll,R.id.negative,R.id.div,R.id.multiply,R.id.t100,R.id.subtract,R.id.sum,R.id.dot,R.id.equals
        };
        mTvResult= findViewById(R.id.result);
        mTvContent= findViewById(R.id.content);
        for(int id : idButtons){
            View view = findViewById(id);
            view.setOnClickListener(this);
        }
    }
    public void math(String symbol){

        if(!Double.isNaN(mValue1))
        {

            mValue2=Double.parseDouble(mTvResult.getText().toString());
            switch (symbol){
                case SUM:
                    mValue1 =mValue1+mValue2;
                    break;
                case SUBTRACT:
                    mValue1=mValue1-mValue2;
                    break;
                case MULTIPLY:
                    mValue1=mValue1*mValue2;
                    break;
                case DIVIDE:
                    mValue1=mValue1/mValue2;
                    break;
                case EQUALS:
                    break;
        }
        } else{
            mValue1 = Double.parseDouble(mTvResult.getText().toString());
        }

    }
    private void init() {
        mContent="";
        mresult="";
        mSymbolMath="";
        mT100=0.0;
        mValue1=Double.NaN;
    }


}
