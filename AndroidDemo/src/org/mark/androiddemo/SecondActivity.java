package org.mark.androiddemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends Activity implements OnClickListener {
    Button btn_0;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button btn_point;
    Button btn_3x;
    Button btn_5x;
    Button btn_10x;
    Button btn_clear;
    Button btn_del;
    Button btn_plus;
    Button btn_minus;
    Button btn_multiply;
    Button btn_divide;
    Button btn_equle;
    Button btn_revert;
    EditText et_input;
    boolean clear_flag;
    boolean up_flag;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		up_flag=true;
		setContentView(R.layout.activity_second);
		btn_0=(Button)findViewById(R.id.button0);
		btn_1=(Button)findViewById(R.id.button1);
		btn_2=(Button)findViewById(R.id.button2);
		btn_3=(Button)findViewById(R.id.button3);
		btn_4=(Button)findViewById(R.id.button4);
		btn_5=(Button)findViewById(R.id.button5);
		btn_6=(Button)findViewById(R.id.button6);
		btn_7=(Button)findViewById(R.id.button7);
		btn_8=(Button)findViewById(R.id.button8);
		btn_9=(Button)findViewById(R.id.button9);
		btn_point=(Button)findViewById(R.id.buttonpoint);
		btn_3x=(Button)findViewById(R.id.button3x);
		btn_5x=(Button)findViewById(R.id.button5x);
		btn_10x=(Button)findViewById(R.id.button10x);
		btn_clear=(Button)findViewById(R.id.buttonc);
		btn_del=(Button)findViewById(R.id.buttondel);
		btn_plus=(Button)findViewById(R.id.buttonplus);
		btn_minus=(Button)findViewById(R.id.buttonminus);
		btn_multiply=(Button)findViewById(R.id.buttonmult);
		btn_divide=(Button)findViewById(R.id.buttondivide);
		btn_equle=(Button)findViewById(R.id.buttonequle);
	    btn_revert = (Button)findViewById(R.id.buttonrevert);
		et_input=(EditText)findViewById(R.id.editText1);
		
		btn_0.setOnClickListener(this);
		btn_1.setOnClickListener(this);
		btn_2.setOnClickListener(this);
		btn_3.setOnClickListener(this);
		btn_4.setOnClickListener(this);
		btn_5.setOnClickListener(this);
		btn_6.setOnClickListener(this);
		btn_7.setOnClickListener(this);
		btn_8.setOnClickListener(this);
		btn_9.setOnClickListener(this);
		btn_point.setOnClickListener(this);
		btn_3x.setOnClickListener(this);
		btn_5x.setOnClickListener(this);
		btn_10x.setOnClickListener(this);
		btn_clear.setOnClickListener(this);
		btn_del.setOnClickListener(this);
		btn_plus.setOnClickListener(this);
		btn_minus.setOnClickListener(this);
		btn_multiply.setOnClickListener(this);
		btn_divide.setOnClickListener(this);
		btn_equle.setOnClickListener(this);
		btn_revert.setOnClickListener(this);
		
	}
	
@Override
public void onClick(View v){
	String str=et_input.getText().toString();
	switch(v.getId()){
	case R.id.button0:
	case R.id.button1:
	case R.id.button2:
	case R.id.button3:
	case R.id.button4:
	case R.id.button5:
	case R.id.button6:
	case R.id.button7:
	case R.id.button8:
	case R.id.button9:
	case R.id.buttonpoint:
    if(clear_flag){
    	clear_flag=false;
    	et_input.setText("");
    	str="";
    }
	et_input.setText(str+((Button)v).getText());
	    break;
	case R.id.buttonplus:
	case R.id.buttonminus:
	case R.id.buttonmult:
	case R.id.buttondivide:
		if(clear_flag){
	    	clear_flag=false;
	    	et_input.setText("");
	    	str="";
	    }
		et_input.setText(str+" "+((Button)v).getText()+" ");
		break;
	case R.id.buttonc:
		et_input.setText("");
		break;
	case R.id.buttondel:
		if(clear_flag){
	    	clear_flag=false;
	    	et_input.setText("");
	    	str="";
	    }
		if(str!=null&&!str.equals("")){
			et_input.setText(str.substring(0,str.length()-1));
		}
		break;
	case R.id.buttonequle:
		getResult();
		break;
	case R.id.button10x:
		String exp=et_input.getText().toString();
		if(exp==null||exp.equals("")){
			return;
		}
		clear_flag=true;
		double d1=Double.parseDouble(exp);
		double result;
		if(up_flag){
	 result=d1*0.1+d1;
	 et_input.setText(result+" ");
		}else if(!up_flag)
		{
	 result=d1-d1*0.1;
	 et_input.setText(result+" ");
		}
		
	break;
	case R.id.button5x:
		String exp2=et_input.getText().toString();
		if(exp2==null||exp2.equals("")){
			return;
		}
		clear_flag=true;
		double d2=Double.parseDouble(exp2);
		double result2;
		if(up_flag){
			result2=d2*0.05+d2;
			et_input.setText(result2+" ");
		}
		else if(!up_flag){
			result2=d2-d2*0.05;
			et_input.setText(result2+" ");
		}
		
	break;
		
	case R.id.button3x:
		String exp3=et_input.getText().toString();
		if(exp3==null||exp3.equals("")){
			return;
		}
		clear_flag=true;
		double d3=Double.parseDouble(exp3);
		double result3;
		if(up_flag){
			result3=d3*0.03+d3;
			et_input.setText(result3+" ");
		}
		else if(!up_flag){
			result3=d3-d3*0.03;
			et_input.setText(result3+" ");
		}
		
		break;
	case R.id.buttonrevert:
		//et_input.setText("0000");
		if(up_flag){
		btn_3x.setText("-3%");
		btn_5x.setText("-5%");
		btn_10x.setText("-10%");
		up_flag=false;
		
		}
		else if(!up_flag){
			btn_3x.setText("3%");
			btn_5x.setText("5%");
			btn_10x.setText("10%");
			up_flag=true;
		}
		break;
	}
	
}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

	private void getResult(){
		String exp=et_input.getText().toString();
		if(exp==null||exp.equals("")){
			return;
		}
		if(!exp.contains(" ")){
			return;
		}
		if(clear_flag==true){
			clear_flag=false;
			return;
		}
		clear_flag=true;
		double result=0;
		String s1=exp.substring(0,exp.indexOf(" "));
		String op=exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);
		String s2=exp.substring(exp.indexOf(" ")+3);
		if(!s1.equals("")&&!s2.equals("")){
			double d1=Double.parseDouble(s1);
			double d2=Double.parseDouble(s2);
			if(op.equals("+")){ result=d1+d2;}
			else if(op.equals("-")){ result=d1-d2;}
				else if(op.equals("x")){ result=d1*d2;}
					else if(op.equals("/")){
						if(d2==0){result=0;}
						else
						result=d1/d2;}
			if(!s1.contains(".")&&!s2.contains(".")){
				int r=(int)result;
				et_input.setText(r+" ");}
			else{
				et_input.setText(result+" ");
			}
					
		}
		else if(!s1.equals("")&&s2.equals("")){
			et_input.setText(exp);
		}
		else{
			et_input.setText(0);
		}
	}
}
