package com.cundong.appblock.util;

import java.io.File;
import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;

public class Util {
	public static AlertDialog createAlertConfirmOrCancelDialog(
			Activity activity, String title, String message,
			String positiveBtn,
			DialogInterface.OnClickListener positiveListener,
			DialogInterface.OnCancelListener cancelListener) {
		return new AlertDialog.Builder(activity).setTitle(title)
				.setMessage(message)
				.setPositiveButton(positiveBtn, positiveListener)
				.setOnCancelListener(cancelListener).create();
	}
	public static AlertDialog createAlertConfirmAndCancelDialog(
			Activity activity, String title, String message,
			String positiveBtn,String negativeString,
			DialogInterface.OnClickListener positiveListener,
			DialogInterface.OnClickListener cancelListener) {
		return new AlertDialog.Builder(activity).setTitle(title)
		.setMessage(message)
		.setPositiveButton(positiveBtn, positiveListener)
		.setNegativeButton(negativeString,cancelListener).create();
	}
	
	// �ж��ļ����Ƿ���ڣ��������򴴽�һ��
	public static boolean isFolderExist(String folderPath) {
		boolean result = false;
		File f = new File(folderPath);
		if (!f.exists()) {
			if (f.mkdir()) {
				result = true;
			} else
				result = false;
		} else
			result = true;

		return result;
	}

	public static int getMiddle(long[] list, int low, int high) {
		long tmp = list[low]; // ����ĵ�һ����Ϊ����
		while (low < high) {
			while (low < high && list[high] > tmp) {
				high--;
			}
			list[low] = list[high]; // ������С�ļ�¼�Ƶ��Ͷ�
			while (low < high && list[low] < tmp) {
				low++;
			}
			list[high] = list[low]; // �������ļ�¼�Ƶ��߶�
		}
		list[low] = tmp; // �����¼��β
		return low; // ���������λ��
	}

	public static void _quickSort(long[] list, int low, int high) {
		if (low < high) {
			int middle = getMiddle(list, low, high); // ��list�������һ��Ϊ��
			_quickSort(list, low, middle - 1); // �Ե��ֱ���еݹ�����
			_quickSort(list, middle + 1, high); // �Ը��ֱ���еݹ�����
		}
	}

	public static void quickSort(long[] str) {
		if (str.length > 0) { // �鿴�����Ƿ�Ϊ��
			_quickSort(str, 0, str.length - 1);
		}
	}

	public static String yymmddhhmmss() {
		Calendar cal = Calendar.getInstance();// ʹ��������
		String year = cal.get(Calendar.YEAR)+"";// �õ���
		String month = cal.get(Calendar.MONTH) + 1+"";// �õ��£���Ϊ��0��ʼ�ģ�����Ҫ��1
		String day = cal.get(Calendar.DAY_OF_MONTH)+"";// �õ���
		String hour = cal.get(Calendar.HOUR)+"";// �õ�Сʱ
		String minute = cal.get(Calendar.MINUTE)+"";// �õ�����
		String second = cal.get(Calendar.SECOND)+"";// �õ���
		Log.i("TB","current time:"+year + month + day+hour + minute + second + "");
		return year + month + day+hour + minute + second ;

	}

}
