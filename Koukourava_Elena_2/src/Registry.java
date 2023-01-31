import java.util.ArrayList;

public class Registry {

	private ArrayList <Suspect> upoptoi = new ArrayList<>();
	private ArrayList <Communication> epikoinwnies = new ArrayList<>();
	
	public void addSuspect(Suspect aSuspect) {
		
		upoptoi.add(aSuspect);
	}
	
	public void addCommunication(Communication aCommunication) {
		
		epikoinwnies.add(aCommunication);
		Suspect upoptos1 = null;
		Suspect upoptos2 = null;
		
		for(int i=0; i<upoptoi.size(); i++) {
			
			ArrayList <String> thlefwna = upoptoi.get(i).getThlefwna();
			
			for(int j=0; j<thlefwna.size();j++) {
				
				if (thlefwna.get(j).equals(aCommunication.getThl1())) {
					upoptos1 = upoptoi.get(i);
				}
			}
		}
		for(int i=0; i<upoptoi.size(); i++) {
			
			ArrayList <String> thlefwna = upoptoi.get(i).getThlefwna();
			
			for(int j=0; j<thlefwna.size();j++) {
				
				if (thlefwna.get(j).equals(aCommunication.getThl2())) {
					upoptos2 = upoptoi.get(i);
				}
			}
		}
		upoptos1.addPithanoiYpoptoi(upoptos2);
	}
	
	public Suspect getSuspectWithMostPartners() {
		
		int max=0;
		int maxsus=0;
		for(int i=0; i<upoptoi.size(); i++) {
			
			if(upoptoi.get(i).getPithanoiYpoptoi().size()>max) {
				max = upoptoi.get(i).getPithanoiYpoptoi().size();
				maxsus = i;
			}
		}
		return upoptoi.get(maxsus);
	}
	public PhoneCall getLongestPhoneCallBetween(String number1, String number2) {
		
		int maxdur=0;
		int maxcall = 0;
		for(int i=0; i<7; i++) {
			
			PhoneCall klhsh = (PhoneCall)epikoinwnies.get(i);
			
			if(epikoinwnies.get(i).getThl1()== number1 && epikoinwnies.get(i).getThl2() == number2) {
				
				if(klhsh.getDiarkeia()>maxdur) {
					maxdur = klhsh.getDiarkeia();
					maxcall = i;
				}
			}
				
		}
		return (PhoneCall)epikoinwnies.get(maxcall);
	}
	public ArrayList <SMS> getMessagesBetween(String number1, String number2) {
		
		ArrayList <SMS> message = new ArrayList<>();
		
		for(int i=7; i<epikoinwnies.size(); i++) {
			
			SMS txt = (SMS)epikoinwnies.get(i);
			
			if(epikoinwnies.get(i).getThl1()== number1 && epikoinwnies.get(i).getThl2() == number2) {
				
				if(txt.getTXT().contains("Bomb")||txt.getTXT().contains("Attack")||txt.getTXT().contains("Gun")||txt.getTXT().contains("Explosives")) {
					message.add(txt);
				}
			}
				
		}
		return message;
	}
	 public void printSuspectsFromCountry(String country) {
		 for(Suspect sus : upoptoi) {
			 if(sus.getXwra() == country) {
				 System.out.println("Suspects coming from "+country+"\n"+sus.getName()+" ("+sus.getCodeName()+")");
			 }
		 }
	 };
}
