


	
	package demo1;
	 
	import java.util.ArrayList;
	import java.util.List;
	 
	import org.testng.annotations.Test;
	 
	import com.fasterxml.jackson.core.JsonProcessingException;
	import com.fasterxml.jackson.core.type.TypeReference;
	import com.fasterxml.jackson.databind.ObjectMapper;
	 
	/* POJO Classs of a JSON Array Payload
	* [{
		  "badmintonBrand" : "Yonex",
		  "raketName" : "Voltric 50 E-tune"
		},{
		  "badmintonBrand" : "Victor",
		  "raketName" : "Woods 20"
		}, {
		 "badmintonBrand" : "Lining",
		  "raketName" : "Woods N-90"
	 
		}]*/
	@Test
	public class POJOClassJSONArrayPayload {
		
		private String badmintonBrand;
		private String rakcetName;
		
		public String getBadmintonBrand() {
			return badmintonBrand;
		}
		public void setBadmintonBrand(String badmintonBrand) {
			this.badmintonBrand = badmintonBrand;
		}
		public String getRakcetName() {
			return rakcetName;
		}
		public void setRakcetName(String rakcetName) {
			this.rakcetName = rakcetName;
		}
	 
		public void CreateList() throws JsonProcessingException {
			//Badminton Detail - 1
			POJOClassJSONArrayPayload yonex = new  POJOClassJSONArrayPayload();
			yonex.setBadmintonBrand("Yonex");
			yonex.setRakcetName("Voltric 50 E-tune");
			
			//Badminton Detail - 2
			POJOClassJSONArrayPayload victor = new  POJOClassJSONArrayPayload();
			victor.setBadmintonBrand("Victor");
			victor.setRakcetName("Woods 20");
			
			//Badminton Detail - 3
			POJOClassJSONArrayPayload lining = new  POJOClassJSONArrayPayload();
			lining.setBadmintonBrand("Lining");
			lining.setRakcetName("Woods N-90");
			
			//creating list
			List<POJOClassJSONArrayPayload> allBadmintonDetails = new ArrayList<POJOClassJSONArrayPayload>();
			allBadmintonDetails.add(yonex);
			allBadmintonDetails.add(victor);
			allBadmintonDetails.add(lining);
			
			//class Object --> String (JSON Array Payload)
			ObjectMapper objMapper1 = new ObjectMapper();
			String allPojoclassJSONPayload = objMapper1.writerWithDefaultPrettyPrinter().writeValueAsString(allBadmintonDetails);
			System.out.println(allPojoclassJSONPayload);
			
			
			//String (JSON Array Payload) --> class Object
			ObjectMapper objMapper2 = new ObjectMapper();
			List<POJOClassJSONArrayPayload> allDetails = objMapper2.readValue(allPojoclassJSONPayload, new TypeReference<List<POJOClassJSONArrayPayload>>() {});
			
			for(POJOClassJSONArrayPayload body: allDetails) {
				System.out.println("==============================================================");
				System.out.println("Badminton Brand: "+body.getBadmintonBrand());
				System.out.println("Racket Name: "+body.getRakcetName());
			}
		}
		
		
		
	 
	}
	 
	 

}
