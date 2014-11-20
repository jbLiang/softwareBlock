package com.cundong.appblock;


import com.cundong.appblock.util.Util;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.Toast;

public class LoginInActivity extends Activity implements OnClickListener{
	private StringBuffer sb = new StringBuffer();// 用来存放输入数字
	private EditText accountET;// 电话号码输入
	private Button one;
	private Button two;
	private Button three;
	private Button four;
	private Button five;
	private Button six;
	private Button seven;
	private Button eight;
	private Button nine;
	private Button zero;

	private Button delete;
	private Button quit;
	private Dialog mDialog;
	private TableLayout girdTL;
	
	private int accountLength =0;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_main);

		initLayout();

	}

	private void initLayout() {
		one = (Button) findViewById(R.id.one);
		two = (Button) findViewById(R.id.two);
		three = (Button) findViewById(R.id.three);
		four = (Button) findViewById(R.id.four);
		five = (Button) findViewById(R.id.five);
		six = (Button) findViewById(R.id.six);
		seven = (Button) findViewById(R.id.seven);
		eight = (Button) findViewById(R.id.eight);
		nine = (Button) findViewById(R.id.nine);
		zero = (Button) findViewById(R.id.zero);

		delete = (Button) findViewById(R.id.delete);
		quit = (Button) findViewById(R.id.quit);
		girdTL = (TableLayout)findViewById(R.id.tl_9grid);

		one.setOnClickListener(this);
		two.setOnClickListener(this);
		three.setOnClickListener(this);
		four.setOnClickListener(this);
		five.setOnClickListener(this);
		six.setOnClickListener(this);
		seven.setOnClickListener(this);
		eight.setOnClickListener(this);
		nine.setOnClickListener(this);
		zero.setOnClickListener(this);

		delete.setOnClickListener(this);
		quit.setOnClickListener(this);
		
		

		accountET = (EditText) findViewById(R.id.et_1);
		accountET.setFocusable(false);// 不让该edittext获得焦点
		accountET.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				accountET.setInputType(InputType.TYPE_NULL); // 关闭软键盘，这样当点击该edittext的时候，不会弹出系统自带的输入法
				return false;
			}

		});

		accountET
		.setFilters(new InputFilter[] { new InputFilter.LengthFilter(6) });
		
		accountET.addTextChangedListener(new TextWatcher() {
			
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
			}
			
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				if(s.length()==6){
					girdTL.setClickable(false);
					if( accountET.getText().toString().equals("903047")){
						Intent intent = new Intent();
						intent.setClass(LoginInActivity.this, MainActivity.class);
						startActivity(intent);
						LoginInActivity.this.finish();
					}else{
						Toast.makeText(LoginInActivity.this, "密码错误,请重新输入  ", Toast.LENGTH_SHORT).show();
					}
				}else{
					girdTL.setClickable(true);
				}
			}
		});
		
		

	}

	public void onClick(View v) {
		
			
		
		switch (v.getId()) {

		case R.id.one:
			if(sb.length() < 6){
			sb.append(one.getText().toString().trim());
			accountET.setText(sb.toString().trim());
			}
			break;
		case R.id.two:
			if(sb.length() < 6){
			sb.append(two.getText().toString().trim());
			accountET.setText(sb.toString().trim());
			}
			break;
		case R.id.three:
			if(sb.length() < 6){
			sb.append(three.getText().toString().trim());
			accountET.setText(sb.toString().trim());
			}
			break;
		case R.id.four:
			if(sb.length() < 6){
			sb.append(four.getText().toString().trim());
			accountET.setText(sb.toString().trim());
			}
			break;
		case R.id.five:
			if(sb.length() < 6){
			sb.append(five.getText().toString().trim());
			accountET.setText(sb.toString().trim());
			 }
			break;
		case R.id.six:
			if(sb.length() < 6){
			sb.append(six.getText().toString().trim());
			accountET.setText(sb.toString().trim());
			 
			}
			break;
		case R.id.seven:
			if(sb.length() < 6){
			sb.append(seven.getText().toString().trim());
			accountET.setText(sb.toString().trim());
			 
			}
			break;
		case R.id.eight:
			if(sb.length() < 6){
			sb.append(eight.getText().toString().trim());
			accountET.setText(sb.toString().trim());
			 
			}
			break;
		case R.id.nine:
			if(sb.length() < 6){
			sb.append(nine.getText().toString().trim());
			accountET.setText(sb.toString().trim());
			 }
			break;
		case R.id.zero:
			if(sb.length()< 6){
			sb.append(zero.getText().toString().trim());
			accountET.setText(sb.toString().trim());
			
			}
			break;
		case R.id.delete:
			if (sb.length() - 1 >= 0) {
				sb.delete(sb.length() - 1, sb.length());
				accountET.setText(sb.toString().trim());
			}
			break;
		case R.id.quit:
			Util.createAlertConfirmAndCancelDialog(this, "系统消息", "您确定退出吗？",
					"确定", "取消", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface arg0, int arg1) {
							System.exit(0);
						}
					}, new DialogInterface.OnClickListener() {

						public void onClick(DialogInterface arg0, int arg1) {
						}
					}).show();
			break;
		default:
			break;
		}
	}
	
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// finish();
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			
				Util.createAlertConfirmAndCancelDialog(this, "系统消息", "您确定退出吗？",
						"确定", "取消", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface arg0, int arg1) {
								System.exit(0);
							}
						}, new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface arg0, int arg1) {
							}
						}).show();
		}

		return true;
	}
}
