package com.springboot.CustomSecurityWithDB;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderTest {

	public static void main(String[] args) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		System.out.println("Password for Gayatri...... " +bCryptPasswordEncoder.encode("Gayatri"));//Admin
		System.out.println("Password for Gopi...... " +bCryptPasswordEncoder.encode("Gopi"));//Guest
		System.out.println("Password for Srinivas...... " +bCryptPasswordEncoder.encode("Srinivas"));
		
		//Password for Gayatri...... $2a$10$mtwacAN.Uyjb99UrE1qswOXq2MQtgz84g34Z0NWNRyxy3BjU.3zIO
		//Password for Gopi...... $2a$10$/DoQRN2mmfTBE6f6.t2nreGJ2XOYiCNn/tTk1atskDYcc9N1kv2mW

		//							$2a$10$6w6rjJXJMwIs0Cn9psNyu.Zjo1e18754Wjsxiev.PDAlbO1dlbuDu
		//							$2a$10$AMN7cfdX1pRTp.SCGAEgTu2JH6AAmjt/.MoGx3bJ8WLK6gbJMdcvK
		//System.out.println("Password for Guest...... " +bCryptPasswordEncoder.encode("guest"));
	}
}
