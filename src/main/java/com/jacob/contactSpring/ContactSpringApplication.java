package com.jacob.contactSpring;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactSpringApplication implements CommandLineRunner{
      	public static void main(String[] args) {
		SpringApplication.run(ContactSpringApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
//       DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//       contactRepository.save(new Contact("KRA","JACOB","kra@yahoo.fr",df.parse("12/05/2018"),05565656L,"cobo.png"));
//       contactRepository.save(new Contact("kobo","Steiner","cobo@yahoo.fr",df.parse("12/05/2018"),05565656L,"cobo.png"));
//       contactRepository.save(new Contact("Bao","JACOB","bao@yahoo.fr",df.parse("12/05/2018"),05565656L,"bao.png"));
//       contactRepository.save(new Contact("KONE","FATIM","kone@yahoo.fr",df.parse("12/05/2018"),05565656L,"jaco.png"));
//       contactRepository.findAll().forEach(c->{
//           System.out.println(c.getNom());
//       });
    }
}
