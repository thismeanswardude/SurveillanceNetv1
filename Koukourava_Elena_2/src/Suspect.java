import java.util.ArrayList;

public class Suspect {
	
		private String onoma,pseudwnumo,polh,xwra;
		public Suspect (String onoma, String pseudwnumo, String polh) {
			
			this.onoma = onoma;
			this.pseudwnumo = pseudwnumo;
			this.polh = polh;
			
		}
		private ArrayList <String> thlefwno = new ArrayList<>();
		
		public void addNumber(String number) {
			
			thlefwno.add(number);
		}
		
		private ArrayList <Suspect> pithanoiupoptoi = new ArrayList<>();
		
		public void addPithanoiYpoptoi(Suspect aSuspect) {
			
			int count=0;
			for(int i=0; i<pithanoiupoptoi.size(); i++) {
				
				if(pithanoiupoptoi.get(i).onoma.equals(aSuspect.onoma)) {
					
					count=1;	
				}
			}
			if (count==0) {
				pithanoiupoptoi.add(aSuspect);
			}
		}
		public ArrayList <String> getThlefwna(){
			
			return thlefwno;
		}
		public ArrayList <Suspect> getPithanoiYpoptoi(){
			
			return pithanoiupoptoi;
		}
		public boolean isConnectedTo(Suspect aSuspect) {
			
			for(int i=0; i<pithanoiupoptoi.size(); i++) {
				
				if(pithanoiupoptoi.get(i).onoma.equals(aSuspect.onoma))
					
					return true;
					
			}
			return false;
		}
		
		private ArrayList <Suspect> koinufoftoi = new ArrayList<>();
		
		public ArrayList <Suspect> getCommonPartners(Suspect aSuspect) {
			
			for(int i=0; i<pithanoiupoptoi.size(); i++) {
				
				if(pithanoiupoptoi.get(i).isConnectedTo(aSuspect)) {
					
					koinufoftoi.add(pithanoiupoptoi.get(i));
				}
			}
			return koinufoftoi;
		}
		
		public void printSUS() {
			
			for(int i=0; i<pithanoiupoptoi.size();i++) {
				
				System.out.println(pithanoiupoptoi.get(i).onoma+" "+pithanoiupoptoi.get(i).pseudwnumo);
			}
		}
		public String getName() {
			
			return onoma;
		}
		public String getCodeName() {
			
			return pseudwnumo;
		}
		
		public String getXwra() {
			if(this.polh == "Barcelona") {
				return "Spain";
			}else if(this.polh == "London") {
				return "England";
			}else {
				return "Norway";
			}
		}
		
}
