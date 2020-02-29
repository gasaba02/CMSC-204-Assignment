
public class Mytest {
	

	public static void main(String[] args) {
		VolunteerLine vl = new VolunteerLine();
		RecipientLine rl = new RecipientLine();
		Volunteer v = new Volunteer("Jim");
		Volunteer v1 = new Volunteer("tom");
		Volunteer v2 = new Volunteer("Jerry");
		
		Recipient r = new Recipient("Tom");
		Recipient r1 = new Recipient("Tomy");
		Recipient r2 = new Recipient("Terry");
		
		
		vl.addNewVolunteer(v);
		vl.addNewVolunteer(v1);
		vl.addNewVolunteer(v2);
		try {
			rl.addNewRecipient(r);
			rl.addNewRecipient(r2);
			rl.addNewRecipient(r1);
			
		} catch (RecipientException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(int i = 0; i < vl.toArrayVolunteer().length; i++) {
			System.out.print(vl.toArrayVolunteer()[i] + " ");
		}
		
		try {
			vl.volunteerTurn();
		} catch (VolunteerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecipientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
		
		
		for(int i = 0; i < vl.toArrayVolunteer().length; i++) {
			System.out.print(vl.toArrayVolunteer()[i] + " ");
		}
		System.out.println();
		
//		for(int i = 0; i < rl.toArrayVolunteer().length; i++) {
//			System.out.print(vl.toArrayVolunteer()[i] + " ");
//		}

		

	}

}
