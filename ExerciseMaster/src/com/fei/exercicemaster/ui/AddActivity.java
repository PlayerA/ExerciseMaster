package com.fei.exercicemaster.ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.fei.exercicemaster.R;
import com.fei.exercicemaster.db.dao.ExerciseDetailDao;
import com.fei.exercicemaster.entity.ExerciseDetail;
import com.fei.exercicemaster.util.Constant;
import com.fei.exercicemaster.util.MyStringUtil;

public class AddActivity extends Activity implements OnClickListener {
	private Spinner sp;
	private ImageView ivSuccess;
	private ImageView ivFail;
	private EditText et1;
	private EditText et2;
	private EditText et3;
	private EditText et4;
	private EditText et5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add);
		init();
		sp.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.type_arr)));

		ivSuccess.setOnClickListener(this);
		ivFail.setOnClickListener(this);
	}

	private void init() {
		sp = (Spinner) findViewById(R.id.sp_select);
		ivSuccess = (ImageView) findViewById(R.id.iv_success);
		ivFail = (ImageView) findViewById(R.id.iv_fail);
		et1 = (EditText) findViewById(R.id.et_group1);
		et2 = (EditText) findViewById(R.id.et_group2);
		et3 = (EditText) findViewById(R.id.et_group3);
		et4 = (EditText) findViewById(R.id.et_group4);
		et5 = (EditText) findViewById(R.id.et_group5);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_fail:
			finish();
			break;
		case R.id.iv_success:
			String type = sp.getSelectedItem().toString();
			
			String num1 = et1.getText().toString().trim();
			if (TextUtils.isEmpty(num1)) {
				Toast.makeText(getApplicationContext(), Constant.AT_LEAST_ONE_GROUP, Toast.LENGTH_LONG).show();
				return;
			}
			String num2 = et2.getText().toString().trim();
			String num3 = et3.getText().toString().trim();
			String num4 = et4.getText().toString().trim();
			String num5 = et5.getText().toString().trim();
			
			List<String> numList = new ArrayList<String>();
			numList.add(num1);
			numList.add(num2);
			numList.add(num3);
			numList.add(num4);
			numList.add(num5);
			String combineNum = MyStringUtil.combineNum(numList);
			
			ExerciseDetailDao dao = new ExerciseDetailDao(this);
			dao.insert(new ExerciseDetail(type, combineNum, new Date()));
			finish();
			break;
		}
	}
}
