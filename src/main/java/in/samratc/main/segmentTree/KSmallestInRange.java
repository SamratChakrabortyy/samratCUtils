package in.samratc.main.segmentTree;

import java.util.Arrays;

import in.samratc.util.SegmentTree;

public class KSmallestInRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { -10937, 7838, -6149, 6823, 2013, -3575, 2476, -4493, 6194, 3576, -6907, 4447, 4121, 3132, -7399,
				6668, 6791, -7154, 10222, 9834, -10596, -7766, 6407, -812, 6612, -99, 1921, -7976, 8684, 7852, 868,
				1178, 10623, 609, 9759, -3188, -424, -9929, -6973, 6269, -8405, 10150, 10295, -5204, 1408, 9328, 9283,
				3410, 10570, 12, 323, -7711, -5643, 9070, 6440, -10062, 6746, 7701, -381, -5193, -4066, 749, -3867,
				-9761, 702, 601, 1114, 723, 872, 2254, 4908, 729, 8469, -3363, -8430, 8882, 7052, 3224, 9719, 6715,
				3379, 482, 10393, 8296, 682, -376, 3302, -3422, 10957, 7818, 7540, 4987, 3644, -5965, 8162, -1307, 5890,
				5751, -9356, 4848, 6407, -3197, 3069, 1894, 4763, -5978, 8208, 9424, -661, 6946, 4965, 3926, 4836, 5449,
				5361, -6302, 7482, 5888, 8059, -9201, 6865, 6592, 4121, -6905, 10730, 8798, 8470, -4115, 7368, 426, 937,
				510, 4307, 5984, -4803, 8960, -7406, 6738, -7510, 1218, 9360, 2693, 10210, 9850, 1002, 9791, 6905, 8931,
				10213, -9806, 6238, 7116, 4337, 8114, 5741, 260, 1046, 9350, 7162, 9973, 7871, -1267, 9838, 5968, 8101,
				-7366, 10768, -4904, -3788, 3566, -7064, 1256, 397, 8534, 4557, 3137, -10998, -7125, 6568, 2431, 8377,
				245, 2281, -6079, 982, 3925, 8752, 8154, 10229, -579, 4086, -5475, 9341, 319, 6590, 7948, 4042, 8533,
				7480, 1443, 2731, 3399, 9412, 5991, 1207, -3047, -7791, 1159, -9089, 10724, 9421, 6318, 7144, 1665,
				8545, -9800, 6162, 5782, 306, 413, 1640, 1546, 6749, -5656, 2710, -10664, 8293, -4982, 4949, 2919, 94,
				6216, 1834, 566, -9114, 2431, 10782, 1477, 4399, 5846, 2884, 10378, -568, -9114, 6009, -9275, -1327,
				7003, 6211, -1640, 3936, 2433, -10694, -1626, 8065, 10706, -669, -9974, 1355, 7336, -7476, -9587, 2080,
				-10657, 9446, -10167, -2827, -10582, -988, -602, 7764, -3866, 9926, 5525, 724, 10875, -9094, -942, 8605,
				3966, -8943, 10707, 632, 7906, -10990, 5032, 9934, 4654, 4147, -7483, 7993, -5375, 1967, 8197, 1447,
				2439, -625, -715, -736, -8254, 3061, -1317, -6746, 10200, 4006, -4105, 10582, 1922, -4127, -1384, 1060,
				1935, -697, -7137, -7285, 10954, 4113, 8790, 10117, 775, 3072, -98, 7961, 145, -6077, -3193, 4953, 8113,
				-4963, 5752, 3819, 7000, 9893, 8107, -9073, 2783, 1908, 2283, 1470, -6137, -5741, 6611, 10976, 9524,
				10564, 6241, -10004, -7580, 7251, -3325, -4116, -7433, 9078, 4473, 6582, 5559, -9338, 3681, -6030, 6594,
				-7779, 1945, -5632, 8169, 8692, 7271, 8444, 9732, 9665, -4925, 447, 4900, 898, -4966, 2653, 8238, 2081,
				359, 8750, 5250, 9899, -3861, 5588, -6354, 330, 2669, 10213, 3746, -7193, 40, 5525, 4759, 5110, 7490,
				1316, 3611, 2540, -10684, 6002, 10953, -47, -4055, 5198, 2582, 3420, 10890, -2775, 8246, 3277, -2024,
				5544, 1705, -6982, -7944, 3584, 8003, 9218, -7989, 7046, -9853, 10648, 8528, -720, -4795, 3254, 7251,
				10228, 7991, 10422, 1313, 247, -3333, -10595, 1476, -4416, -4377, 10820, 9664, 2221, -4603, 10246,
				10958, 4437, -6208, 9292, 5957, -5879, 7945, -2617, 10435, 8552, -8051, -2569, -5195, -8879, 5120,
				-8779, -5066, 106, 4200, 1901, 9754, 8187, 1907, -2511, 7925, 80, 5737, 3109, 1183, 10558, -9254, -6741,
				-3085, -1293, 8096, 10686, 2638, 6191, 7113, 1696, -8726, 7294, 5342, 4767, 2956, 10063, -10015, -5432,
				3747, 5982, 8446, -6682, 4628, 738, -5823, 2101, 10344, 7801, 2872, 10017, -108, 1245, -8339, -9822,
				7876, 5797, 7642, -10405, 7076, -6361, -2893, 5028, 301, 8575, 9182, 10871, 7056, -4160, -8632, 9766,
				4062, -10899, 5891, 4569, 1677, 10233, -10150, 2328, 5400, -1691, -4032, -365, 3261, 10739, 4842, 2459,
				8644 },
				queries[][] = { { 199, 341, 27 }, { 21, 486, 386 }, { 19, 496, 424 }, { 3, 526, 327 }, { 47, 247, 49 },
						{ 377, 497, 5 }, { 16, 522, 26 }, { 3, 535, 408 }, { 74, 254, 140 }, { 19, 310, 267 },
						{ 135, 391, 75 }, { 195, 198, 2 }, { 21, 517, 434 }, { 27, 511, 139 }, { 5, 533, 145 },
						{ 159, 447, 163 }, { 43, 333, 67 }, { 226, 407, 144 }, { 119, 276, 72 }, { 5, 533, 390 },
						{ 23, 204, 123 }, { 0, 538, 184 }, { 0, 538, 480 }, { 66, 377, 6 }, { 12, 526, 117 },
						{ 91, 405, 78 }, { 221, 243, 21 }, { 401, 421, 17 }, { 429, 520, 43 }, { 14, 524, 379 },
						{ 10, 528, 265 }, { 164, 457, 294 }, { 6, 457, 140 }, { 2, 337, 32 }, { 358, 438, 9 },
						{ 2, 42, 32 }, { 23, 485, 178 }, { 17, 523, 500 }, { 389, 492, 5 }, { 226, 515, 90 },
						{ 299, 486, 147 }, { 150, 221, 27 }, { 119, 292, 28 }, { 25, 513, 173 }, { 11, 311, 208 },
						{ 8, 335, 250 }, { 45, 424, 188 }, { 4, 534, 216 }, { 317, 449, 15 }, { 1, 539, 539 },
						{ 35, 400, 88 }, { 302, 338, 12 }, { 290, 425, 112 }, { 17, 521, 443 }, { 310, 473, 70 },
						{ 134, 310, 55 }, { 65, 248, 182 }, { 6, 532, 526 }, { 97, 519, 217 }, { 194, 407, 166 },
						{ 143, 451, 30 }, { 312, 448, 40 }, { 140, 534, 271 }, { 254, 332, 61 }, { 9, 529, 180 },
						{ 366, 515, 134 }, { 170, 456, 227 }, { 408, 425, 7 }, { 52, 57, 4 }, { 48, 510, 437 },
						{ 308, 348, 25 }, { 102, 190, 60 }, { 75, 301, 31 }, { 51, 484, 248 }, { 90, 345, 16 },
						{ 140, 292, 21 }, { 21, 517, 359 }, { 205, 365, 22 }, { 8, 423, 406 }, { 225, 273, 26 },
						{ 42, 84, 40 }, { 71, 105, 3 }, { 75, 260, 169 }, { 0, 538, 337 }, { 417, 454, 26 },
						{ 213, 467, 166 }, { 123, 372, 185 }, { 145, 240, 75 }, { 234, 417, 12 }, { 280, 476, 138 },
						{ 15, 233, 158 }, { 207, 404, 112 }, { 257, 514, 184 }, { 110, 189, 57 }, { 105, 404, 184 },
						{ 5, 476, 20 }, { 314, 362, 43 }, { 176, 188, 6 }, { 31, 103, 12 }, { 324, 352, 9 },
						{ 62, 385, 257 }, { 317, 449, 60 }, { 212, 482, 29 }, { 109, 466, 226 }, { 63, 200, 43 },
						{ 354, 406, 13 }, { 408, 511, 78 }, { 92, 358, 70 }, { 340, 355, 3 }, { 176, 480, 223 },
						{ 25, 513, 326 }, { 279, 498, 29 }, { 352, 467, 91 }, { 312, 489, 41 }, { 16, 368, 188 },
						{ 4, 534, 373 }, { 3, 403, 345 }, { 143, 313, 44 }, { 18, 520, 265 }, { 182, 474, 278 },
						{ 5, 437, 210 }, { 48, 58, 5 }, { 19, 519, 293 }, { 324, 388, 60 }, { 390, 444, 7 },
						{ 63, 254, 58 }, { 479, 530, 12 }, { 150, 371, 36 }, { 317, 318, 1 }, { 191, 416, 104 },
						{ 142, 436, 76 }, { 283, 380, 88 }, { 75, 406, 182 }, { 94, 462, 140 }, { 59, 528, 90 },
						{ 11, 317, 117 }, { 5, 57, 33 }, { 12, 526, 303 }, { 14, 524, 43 }, { 420, 508, 75 },
						{ 472, 523, 26 }, { 8, 286, 136 }, { 73, 281, 198 }, { 17, 287, 149 }, { 164, 171, 7 },
						{ 58, 371, 71 }, { 38, 350, 265 }, { 79, 425, 194 }, { 305, 306, 1 }, { 425, 452, 16 },
						{ 173, 212, 6 }, { 46, 134, 12 }, { 59, 268, 208 }, { 226, 301, 24 }, { 126, 314, 76 },
						{ 179, 205, 21 }, { 94, 102, 1 }, { 104, 338, 139 }, { 94, 178, 23 }, { 252, 321, 1 },
						{ 449, 463, 12 }, { 105, 393, 192 }, { 276, 304, 15 }, { 17, 444, 195 }, { 109, 136, 9 },
						{ 188, 446, 114 }, { 34, 139, 58 }, { 2, 536, 489 }, { 172, 447, 163 }, { 373, 412, 22 },
						{ 11, 527, 160 }, { 4, 534, 435 }, { 350, 437, 80 }, { 142, 521, 302 }, { 29, 509, 248 },
						{ 122, 425, 145 }, { 177, 383, 206 }, { 6, 192, 6 }, { 104, 417, 15 }, { 14, 524, 77 },
						{ 18, 520, 153 }, { 243, 323, 51 }, { 105, 147, 8 }, { 36, 216, 62 }, { 349, 401, 38 },
						{ 178, 437, 24 }, { 163, 419, 21 }, { 137, 408, 240 }, { 64, 181, 92 }, { 233, 245, 5 },
						{ 457, 511, 15 }, { 274, 362, 60 }, { 134, 175, 9 }, { 113, 151, 22 }, { 181, 422, 163 },
						{ 121, 187, 9 }, { 25, 513, 335 }, { 79, 202, 8 }, { 266, 319, 3 }, { 2, 536, 375 },
						{ 400, 438, 31 }, { 185, 478, 116 }, { 94, 255, 110 }, { 48, 451, 54 }, { 64, 289, 10 },
						{ 269, 465, 70 }, { 6, 532, 135 }, { 22, 516, 217 }, { 165, 464, 3 }, { 21, 517, 408 },
						{ 43, 90, 26 }, { 40, 296, 11 }, { 258, 272, 15 }, { 116, 310, 161 }, { 164, 528, 331 },
						{ 432, 458, 17 }, { 278, 474, 184 }, { 214, 439, 116 }, { 2, 536, 287 }, { 260, 472, 84 },
						{ 100, 265, 113 }, { 4, 534, 295 }, { 348, 366, 7 }, { 308, 450, 113 }, { 120, 475, 14 },
						{ 175, 180, 4 }, { 68, 74, 2 }, { 29, 509, 344 }, { 19, 519, 358 }, { 124, 528, 288 },
						{ 93, 411, 9 }, { 7, 385, 83 }, { 264, 370, 7 }, { 68, 153, 33 }, { 194, 411, 148 },
						{ 201, 486, 270 }, { 432, 534, 85 }, { 13, 525, 9 }, { 161, 520, 307 }, { 334, 479, 139 },
						{ 61, 110, 47 }, { 32, 279, 65 }, { 137, 249, 45 }, { 83, 387, 195 }, { 95, 277, 90 },
						{ 228, 395, 26 }, { 216, 429, 76 }, { 229, 376, 23 }, { 19, 519, 281 }, { 189, 532, 217 },
						{ 267, 282, 3 }, { 10, 528, 37 }, { 16, 429, 370 }, { 241, 476, 175 }, { 116, 420, 152 },
						{ 223, 421, 76 }, { 17, 461, 335 }, { 62, 366, 266 }, { 127, 160, 17 }, { 18, 520, 410 },
						{ 323, 335, 3 }, { 67, 90, 22 }, { 44, 267, 54 }, { 190, 410, 187 }, { 344, 347, 1 },
						{ 166, 410, 155 }, { 74, 307, 22 }, { 4, 534, 234 }, { 82, 383, 174 }, { 207, 418, 41 },
						{ 117, 242, 36 }, { 266, 443, 86 }, { 413, 446, 1 }, { 39, 434, 95 }, { 238, 497, 200 },
						{ 12, 526, 194 }, { 375, 491, 5 }, { 170, 394, 39 }, { 201, 426, 222 }, { 107, 218, 63 },
						{ 53, 396, 307 }, { 200, 491, 98 }, { 203, 342, 50 }, { 12, 372, 353 }, { 9, 529, 169 },
						{ 345, 465, 78 }, { 30, 239, 176 }, { 392, 395, 1 }, { 75, 302, 58 }, { 285, 471, 86 },
						{ 4, 534, 501 }, { 127, 468, 181 }, { 74, 403, 152 }, { 17, 478, 217 }, { 250, 534, 250 },
						{ 205, 284, 54 }, { 397, 469, 58 }, { 8, 423, 51 }, { 353, 489, 12 }, { 127, 395, 4 },
						{ 120, 320, 9 }, { 333, 473, 129 }, { 36, 474, 48 }, { 247, 416, 18 }, { 107, 169, 59 },
						{ 68, 190, 3 }, { 22, 529, 28 }, { 285, 513, 93 }, { 212, 392, 49 }, { 78, 495, 108 },
						{ 192, 209, 15 }, { 145, 443, 53 }, { 151, 440, 12 }, { 242, 257, 8 }, { 257, 437, 24 },
						{ 15, 523, 383 }, { 59, 290, 139 }, { 338, 453, 60 }, { 60, 236, 22 }, { 59, 535, 346 },
						{ 174, 448, 138 }, { 111, 379, 52 }, { 158, 195, 26 }, { 12, 21, 10 }, { 0, 538, 421 },
						{ 272, 364, 4 }, { 370, 423, 25 }, { 340, 505, 70 }, { 71, 170, 43 }, { 164, 383, 69 },
						{ 113, 504, 163 }, { 164, 299, 97 }, { 120, 130, 9 }, { 8, 66, 16 }, { 375, 442, 29 },
						{ 39, 359, 167 }, { 71, 391, 107 }, { 354, 488, 91 }, { 312, 360, 42 }, { 301, 364, 10 },
						{ 238, 527, 98 }, { 128, 235, 65 }, { 285, 524, 176 }, { 55, 154, 94 }, { 27, 134, 23 },
						{ 178, 338, 14 }, { 194, 393, 43 }, { 27, 511, 57 }, { 15, 523, 118 }, { 104, 157, 32 },
						{ 112, 339, 52 }, { 8, 530, 4 }, { 6, 207, 119 }, { 112, 501, 294 }, { 354, 477, 75 },
						{ 449, 536, 24 }, { 136, 331, 141 }, { 115, 274, 67 }, { 203, 468, 12 }, { 2, 536, 25 },
						{ 255, 409, 139 }, { 188, 254, 22 }, { 494, 509, 3 }, { 156, 243, 26 }, { 26, 512, 134 },
						{ 344, 412, 29 }, { 103, 435, 311 }, { 471, 507, 16 }, { 16, 522, 105 }, { 93, 492, 99 },
						{ 94, 390, 292 }, { 18, 87, 33 }, { 148, 349, 14 }, { 180, 306, 76 }, { 238, 337, 74 },
						{ 53, 296, 30 }, { 37, 162, 59 }, { 245, 529, 88 }, { 5, 533, 140 }, { 309, 331, 7 },
						{ 122, 322, 130 }, { 1, 537, 380 }, { 24, 277, 182 }, { 235, 414, 73 }, { 306, 387, 59 },
						{ 392, 492, 27 }, { 462, 464, 2 }, { 364, 425, 14 }, { 28, 510, 160 }, { 43, 467, 380 },
						{ 191, 528, 18 }, { 104, 413, 131 }, { 309, 310, 2 }, { 235, 394, 136 }, { 12, 96, 30 },
						{ 176, 450, 217 }, { 221, 338, 54 }, { 12, 251, 181 }, { 272, 378, 103 }, { 176, 288, 11 },
						{ 274, 434, 110 }, { 20, 518, 187 }, { 65, 476, 311 }, { 333, 410, 57 }, { 331, 377, 14 },
						{ 156, 414, 2 }, { 4, 534, 227 }, { 148, 420, 166 }, { 3, 86, 15 }, { 25, 513, 230 },
						{ 34, 488, 147 }, { 2, 273, 160 }, { 11, 176, 156 }, { 21, 517, 328 }, { 20, 518, 199 },
						{ 51, 497, 172 }, { 74, 518, 218 }, { 120, 289, 105 }, { 162, 228, 26 }, { 7, 531, 87 },
						{ 512, 518, 2 }, { 23, 515, 293 }, { 19, 519, 467 }, { 142, 473, 286 }, { 67, 122, 31 },
						{ 232, 272, 4 }, { 15, 523, 32 }, { 7, 531, 329 }, { 133, 504, 135 }, { 154, 419, 232 },
						{ 3, 461, 99 }, { 265, 478, 130 }, { 278, 477, 100 }, { 460, 506, 26 }, { 74, 138, 10 },
						{ 92, 425, 57 }, { 27, 511, 282 }, { 2, 536, 323 }, { 191, 370, 8 }, { 396, 491, 15 },
						{ 26, 512, 376 }, { 331, 395, 8 }, { 362, 473, 64 }, { 94, 123, 18 }, { 29, 509, 112 },
						{ 174, 381, 32 }, };
		System.out.println(Arrays.toString(new KSmallestInRangeSol().solve(arr, queries)));
	}

}

class KSmallestInRangeSol {

	public int[] solve(int[] a, int[][] queries) {
		// Null Check
		if (a == null || queries == null)
			return a;

		Integer[] arr = Arrays.stream(a).boxed().toArray(Integer[]::new);
		SegmentTree<Integer, Integer[]> sortedRangeSegmentTree = new SegmentTree<>(Integer[].class, arr,
				this::mergeSorted, this::toArray);

		int n = queries.length;
		int[] ans = new int[n];

		for (int i = 0; i < n; i++) {
			int start = --queries[i][0], end = --queries[i][1], k = --queries[i][2];
			ans[i] = sortedRangeSegmentTree.query(start, end)[k];
		}
		return ans;
	}

	private Integer[] toArray(Integer a) {
		Integer[] temp = new Integer[1];
		temp[0] = a;
		return temp;
	}

	private Integer[] mergeSorted(Integer[] arr1, Integer[] arr2) {
		Integer[] ans = {};
		if ((arr1 == null && arr2 == null) || (arr1.length == 0 && arr2.length == 0))
			return ans;
		else if (arr1 == null || arr1.length == 0)
			return arr2.clone();
		else if (arr2 == null || arr2.length == 0)
			return arr1.clone();
		int n = arr1.length, m = arr2.length;
		ans = new Integer[n + m];
		int i = 0, j = 0, k = 0;
		while (i < n && j < m) {
			if (arr1[i] < arr2[j])
				ans[k++] = arr1[i++];
			else
				ans[k++] = arr2[j++];
		}
		while (i < n)
			ans[k++] = arr1[i++];
		while (j < m)
			ans[k++] = arr2[j++];
		return ans;
	}

}
