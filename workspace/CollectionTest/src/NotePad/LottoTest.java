package NotePad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class LottoSystem{
	
	
	public  boolean check(List<Integer> lotto) {
		
		Set<Integer> tmp = new HashSet<Integer>();
		boolean flag = true;
		
		tmp.add(12);
		tmp.add(15);
		tmp.add(17);
		tmp.add(24);
		tmp.add(29);
		tmp.add(45);
		
		Iterator<Integer> it = tmp.iterator();
		
		int i = 0;
		while(it.hasNext()) {
			int n = it.next();
			int m = lotto.get(i);
			i++;
			if(n != m) {
				flag = false;
			}
			
		}
		
		return flag;
	}
	
}


public class LottoTest {
	
	public static void main(String[] args) {
	
		LottoSystem ls = new LottoSystem();
		Set<Integer> list = new HashSet<Integer>();
		
//		list.add(12);
//		list.add(15);
//		list.add(17);
//		list.add(24);
//		list.add(29);
//		
//		List<Integer> lotto = new ArrayList<Integer>(list);
//		
//		System.out.println(ls.check(lotto));
		
		
		int cnt = 0;
		while(true) {			
			for(int i = 0; list.size() < 6; i++) {
				int n = (int)(Math.random() * 45 + 1);
				list.add(n);			
			}
			
			List<Integer> lotto = new ArrayList<Integer>(list); 
			
			if(ls.check(lotto)) {
				Collections.sort(lotto);
				System.out.println(lotto);
				break;
			}else {
				System.out.println();
				System.out.println(lotto);
				System.out.println("Try : " + cnt);
				System.out.println();
				list.clear();
				cnt++;				
			}
			
		}
		
		
		
	}
}
