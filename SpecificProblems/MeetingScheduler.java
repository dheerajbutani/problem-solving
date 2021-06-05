/**
 * Jun 3, 2021
 */


import java.util.ArrayList;
import java.util.List;

/**
 * @author Dheeraj
 *
*
 */
public class MeetingScheduler {

	/**
	 * @param args
	 *      input is sorted 
	 * 		busy slots of A: [["09:00","10:30"],["12:00","13:00"],["16:00","18:00"]]
	 * 		
	 * 								i
	 * 		busy slots of B: [["10:30","11:30"],["12:30","14:30"],["14:30","15:00"],["16:00","17:00"]]
	 * 
	 * 	  	Meeting contraint for A: ["07:00","20:00"]   //meeting for A cannot be scheduled outside of this		
	 * 
	 * 		Meeting contraint for B: ["08:00","19:00"]   //meeting for B cannot be scheduled outside of this
	 * 
	 * Solution:
	 *      merge overlapping busy slots
	 * 	    
	 * 		busy slots of A and B:[["09:00","11:30"],["12:00","14:30"],["14:30","15:00"],["16:00","18:00"]]
	 * 		
	 * 
	 * 		in busy slots of A and B choose the first slot start time as end time with start time of meeting constraints and merge them
	 * 		similarly find free slots for end time meeting constraint
	 * 
	 * 		free slots:	  [[08:00, 09:00], [11:30, 12:00], [15:00, 16:00], [18:00, 19:00]]
	 * 
	 */
	
	
	public static void main(String[] args) {
		// Driver code:
		
		List<List<String>> withBusyIntervalsOfA = new ArrayList<>();
		
		List<List<String>> withBusyIntervalsOfB = new ArrayList<>();
		
		List<String> meetingConstraintOfA = new ArrayList<>();
		
		List<String> meetingConstraintOfB = new ArrayList<>();
		
		meetingConstraintOfA.add("07:00");
		meetingConstraintOfA.add("20:00");
		
		
		meetingConstraintOfB.add("08:00");
		meetingConstraintOfB.add("19:00");
		
		int forDuration = 30;
		
		List<String> l1=new ArrayList<>();
		List<String> l2=new ArrayList<>();
		List<String> l3=new ArrayList<>();
		List<String> r1=new ArrayList<>();
		List<String> r2=new ArrayList<>();
		List<String> r3=new ArrayList<>();
		List<String> r4=new ArrayList<>();
		
		l1.add("09:00");
		l1.add("10:30");
		l2.add("12:00");
		l2.add("13:00");
		l3.add("16:00");
		l3.add("18:00");
		
		withBusyIntervalsOfA.add(l1);
		withBusyIntervalsOfA.add(l2);
		withBusyIntervalsOfA.add(l3);
		
		
		r1.add("10:30");
		r1.add("11:30");
		r2.add("12:30");
		r2.add("14:30");
		r3.add("14:30");
		r3.add("15:00");
		r4.add("16:00");
		r4.add("17:00");
		
		
		withBusyIntervalsOfB.add(r1);
		withBusyIntervalsOfB.add(r2);
		withBusyIntervalsOfB.add(r3);
		withBusyIntervalsOfB.add(r4);
		
		
		
		
		List<List<String>> freeSchedules = getFreeIntervals(forDuration, withBusyIntervalsOfA, withBusyIntervalsOfB, meetingConstraintOfA, meetingConstraintOfB);
		System.out.println(freeSchedules);
	}

	/**
	 * @param forDuration
	 * @param withBusyIntervalsOfA
	 * @param withBusyIntervalsOfB
	 * @return
	 */
	private static List<List<String>> getFreeIntervals(int forDuration, List<List<String>> withBusyIntervalsOfA,
		List<List<String>> withBusyIntervalsOfB, List<String> meetingConstraintOfA,List<String> meetingConstraintOfB) {
		
		List<List<String>> freeBlocks = new ArrayList<>();
		
		List<List<String>> mergedBusyBlocks = new ArrayList<>();
		
		int currentIntervalOfA=0;int currentIntervalOfB=0;
		
		while (currentIntervalOfA<withBusyIntervalsOfA.size() && currentIntervalOfB<withBusyIntervalsOfB.size()) {
			if((withBusyIntervalsOfA.get(currentIntervalOfA).get(0).compareTo(withBusyIntervalsOfB.get(currentIntervalOfB).get(0))<=0 &&
					withBusyIntervalsOfA.get(currentIntervalOfA).get(1).compareTo(withBusyIntervalsOfB.get(currentIntervalOfB).get(0))>=0)
					||
					(withBusyIntervalsOfB.get(currentIntervalOfB).get(1).compareTo(withBusyIntervalsOfA.get(currentIntervalOfA).get(0))>=0
					&&
					withBusyIntervalsOfB.get(currentIntervalOfB).get(1).compareTo(withBusyIntervalsOfA.get(currentIntervalOfA).get(1))<=0
							)){
				
				String mergedStart = withBusyIntervalsOfA.get(currentIntervalOfA).get(0).compareTo(withBusyIntervalsOfB.get(currentIntervalOfB).get(0))<=0?withBusyIntervalsOfA.get(currentIntervalOfA).get(0):withBusyIntervalsOfB.get(currentIntervalOfB).get(0);
				String mergedEnd= withBusyIntervalsOfA.get(currentIntervalOfA).get(1).compareTo(withBusyIntervalsOfB.get(currentIntervalOfB).get(1))>=0?withBusyIntervalsOfA.get(currentIntervalOfA).get(1):withBusyIntervalsOfB.get(currentIntervalOfB).get(1);
				
				
				List<String> mergedInterval = new ArrayList<>();
				mergedInterval.add(mergedStart);
				mergedInterval.add(mergedEnd);
				mergedBusyBlocks.add(mergedInterval);

				++currentIntervalOfA;
			++currentIntervalOfB;
			}
			else if(withBusyIntervalsOfB.get(currentIntervalOfB).get(1).compareTo(withBusyIntervalsOfA.get(currentIntervalOfA).get(1))>=0){
				mergedBusyBlocks.add(withBusyIntervalsOfA.get(currentIntervalOfA));
				++currentIntervalOfA;
			}
			else{
				mergedBusyBlocks.add(withBusyIntervalsOfB.get(currentIntervalOfB));
				++currentIntervalOfB;
			}
			
		}
		
		while(currentIntervalOfA<withBusyIntervalsOfA.size()){
			mergedBusyBlocks.add(withBusyIntervalsOfA.get(currentIntervalOfA));
			++currentIntervalOfA;
		}
		while(currentIntervalOfB<withBusyIntervalsOfB.size()){
			System.out.println(currentIntervalOfA+" "+currentIntervalOfB);
			mergedBusyBlocks.add(withBusyIntervalsOfB.get(currentIntervalOfB));
			++currentIntervalOfB;
		}
		
		System.out.println("******************************");
		System.out.println("Merged blocks of busy time");
		System.out.println("******************************");
		
		for(List<String> block:mergedBusyBlocks){
			System.out.println(block);
		}
		
		System.out.println("******************************");
		System.out.println("Free Intervals");
		System.out.println("******************************");
		
		String freeStartOfDayForAB = meetingConstraintOfA.get(0).compareTo(meetingConstraintOfB.get(0))>0?meetingConstraintOfA.get(0):meetingConstraintOfB.get(0);
		String busyStartTimeOfDayForAB = mergedBusyBlocks.get(0).get(0);
		
		if(freeStartOfDayForAB.compareTo(busyStartTimeOfDayForAB)<0){
			List<String> mergedInterval = new ArrayList<>();
			mergedInterval.add(freeStartOfDayForAB);
			mergedInterval.add(busyStartTimeOfDayForAB);
			freeBlocks.add(mergedInterval);
		}
		
		for(int i=0;i<mergedBusyBlocks.size()-1;i++){
			if(mergedBusyBlocks.get(i).get(1).compareTo(mergedBusyBlocks.get(i+1).get(0))==-1){
				List<String> freeInterval = new ArrayList<>();
				freeInterval.add(mergedBusyBlocks.get(i).get(1));
				freeInterval.add(mergedBusyBlocks.get(i+1).get(0));
				freeBlocks.add(freeInterval);
			}
			
		}
		
		String endOfDayForAB = meetingConstraintOfA.get(1).compareTo(meetingConstraintOfB.get(1))<0?meetingConstraintOfA.get(1):meetingConstraintOfB.get(1);
		String busyEndTimeOfDayForAB = mergedBusyBlocks.get(mergedBusyBlocks.size()-1).get(1);
		
		if(endOfDayForAB.compareTo(busyEndTimeOfDayForAB)>0){
			List<String> mergedInterval = new ArrayList<>();
			mergedInterval.add(busyEndTimeOfDayForAB);
			mergedInterval.add(endOfDayForAB);
			freeBlocks.add(mergedInterval);
		}
		
		return freeBlocks;
	}


}
