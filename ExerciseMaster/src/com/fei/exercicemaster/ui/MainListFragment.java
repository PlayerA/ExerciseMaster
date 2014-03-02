package com.fei.exercicemaster.ui;


import java.text.ParseException;
import java.util.List;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.fei.exercicemaster.R;
import com.fei.exercicemaster.adapter.MainListAdapter;
import com.fei.exercicemaster.db.dao.ExerciseDetailDao;
import com.fei.exercicemaster.entity.ExerciseDetail;

/**
 *	功能描述：列表Fragment，用来显示滑动菜单打开后的内容
 */
public class MainListFragment extends ListFragment {
	private ImageButton imgBtn;
	private List<ExerciseDetail> detailList = null;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.list, null); 
		imgBtn  = (ImageButton) view.findViewById(R.id.ib_add);
		return view;
	}
	
	@Override
	public void onStart() {
		super.onStart();
		try {
			detailList = new ExerciseDetailDao(getActivity()).retrieveAll();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		MainListAdapter adapter = new MainListAdapter(detailList, getActivity());
		setListAdapter(adapter);
		
		imgBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				goAddPage();
			}

			
		});
	}
	
	@Override
	public void onListItemClick(final ListView l, View v, final int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		new AlertDialog.Builder(getActivity()).setItems(new String[]{"删除","更改"}, new AlertDialog.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				switch (which) {
				case 0:
					confirmDelete(position);
					break;
				case 1:
					
					break;
				}
			}

		
		}).create().show();
	}
	
	private void goAddPage() {
		startActivityForResult((new Intent(getActivity(), AddActivity.class)), 0);
	}
	private void confirmDelete(final int position) {
		new AlertDialog.Builder(getActivity()).setMessage("确定要删除?")
		.setPositiveButton("确定", new AlertDialog.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				ExerciseDetail detail = detailList.get(position);
				ExerciseDetailDao dao = new ExerciseDetailDao(getActivity());
				dao.deleteById(detail.getId());
				try {
					detailList = dao.retrieveAll();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				MainListAdapter adapter = new MainListAdapter(detailList, getActivity());
				setListAdapter(adapter);
			}
		}).setNegativeButton("取消", new AlertDialog.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
			}
		}).create().show();
		
	}
}
