package interview.questions.linkedin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 * 
 */
// O(n) space, O(nlgn) time
public class MergeIntervals {

	public static int findRange(ArrayList<Interval> intervals) {
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				if (o1.start > o2.start) {
					return 1;
				} else if (o1.start > o2.start) {
					return -1;
				} else if (o1.end > o2.end) {
					return 1;
				} else if (o1.end > o2.end) {
					return -1;
				} else {
					return 0;
				}
			}
		});

		int range = 0;
		int s = 0;
		int i = 0;
		while (i < intervals.size()) {
			int j = i + 1;
			int e = intervals.get(i).end;
			while (j < intervals.size() && e >= intervals.get(j).start) {
				e = Math.max(e, intervals.get(j).end);
				j++;

			}
			range += e - intervals.get(s).start;
			i = j;
			s = j;
		}
		return range;
	}

	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public class Solution {
		public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
			// Start typing your Java solution below
			// DO NOT write main() function
			ArrayList<Interval> res = new ArrayList<Interval>();
			if (intervals.size() == 0) {
				return res;
			}

			Collections.sort(intervals, new IntervalSorter());
			int start = intervals.get(0).start;
			int end = intervals.get(0).end;

			for (int i = 1; i < intervals.size(); ++i) {
				int curStart = intervals.get(i).start;
				int curEnd = intervals.get(i).end;
				if (end >= curStart) { // there is overlap, can merge, update
										// end
					end = Math.max(end, curEnd);
				} else { // not overlap, cannot merge, add previous one
					res.add(new Interval(start, end));
					start = curStart;
					end = curEnd;
				}
			}

			res.add(new Interval(start, end));
			return res;
		}

		private class IntervalSorter implements Comparator<Interval> {
			public int compare(Interval i1, Interval i2) {
				int cmp = i1.start - i2.start;
				return cmp == 0 ? i1.end - i2.end : cmp;
			}
		}
	}

}
