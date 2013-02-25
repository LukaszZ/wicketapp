package com.lzola.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class BigDecimalUtils {

	public static String formatToCurrency(BigDecimal value) {
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(2);
		return df.format(value);
	}
}
