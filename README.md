“Project(Moviebooking) Deployment Documentation – Maven Build and Tomcat Deployment”

**1. Create EC2 Instance for Build Server**
    Launch a new EC2 instance to build the project.
    Use your preferred AMI (recommended: Ubuntu 24.04 LTS).
    Configure the key pair and download the .pem file.

<img width="1912" height="918" alt="Image" src="https://github.com/user-attachments/assets/f67f275c-aa60-473a-a8f8-39d68243bf31" />

<img width="1880" height="926" alt="Image" src="https://github.com/user-attachments/assets/8f3e83ca-a2e4-448e-af8a-9675bfa1eb3e" />

**2. Connect to the Build Server via SSH**
    Use the following command to connect:
    ssh -i "name.pem" ubuntu@<BUILD_SERVER_IP>

<img width="1896" height="868" alt="Image" src="https://github.com/user-attachments/assets/ab11ff9d-99a1-43e1-b8ef-f1b68905369d" />

**3.Verify Server Access**
   Ensure that you can access the server terminal successfully.

<img width="1910" height="958" alt="Image" src="https://github.com/user-attachments/assets/dc82320f-6f37-47f5-b465-c6733534b1c5" />

**4.Check Java and Maven Installation**
   Check if Java is installed:
   java --version
   Check if Maven is installed:
   mvn --version

<img width="1241" height="590" alt="Image" src="https://github.com/user-attachments/assets/0d9028f2-8c5e-4e8d-a87e-53e8823d4f24" />

   If not installed, run:
   sudo apt update
   sudo apt install openjdk-17-jdk -y
   sudo apt install maven -y

<img width="1273" height="598" alt="Image" src="https://github.com/user-attachments/assets/6d82e435-d796-4912-a231-d1081bcbfda7" />

**5. Clone Code from GitHub**

<img width="1902" height="937" alt="Image" src="https://github.com/user-attachments/assets/bb74a4da-2ebc-4e90-9d25-584558d4beb1" />
  
  Clone your application repository:

<img width="1236" height="603" alt="Image" src="https://github.com/user-attachments/assets/3288d43a-3053-43c0-ab43-6a9b89181e23" />

**6. Validate Maven Build and Package**
    Run the following commands:
    mvn validate
    mvn package

<img width="1918" height="747" alt="Image" src="https://github.com/user-attachments/assets/6f209dd1-ff78-425e-81e1-f3e20c25142a" />

   If the build fails due to Java version incompatibility, update your pom.xml:
  <properties>
    <maven.compiler.source>17</maven.compiler.source>
    <maven.compiler.target>17</maven.compiler.target>
  </properties>

<img width="1912" height="952" alt="Image" src="https://github.com/user-attachments/assets/6d3a4b20-0917-4be5-b0f4-f6c1ea77f983" />

<img width="1916" height="930" alt="Image" src="https://github.com/user-attachments/assets/c1391084-c402-4d87-867e-c3cd1837ae46" />

   Then rerun:
mvn validate
mvn package

<img width="1302" height="767" alt="Image" src="https://github.com/user-attachments/assets/b0037b14-5612-4b4a-9938-b39619e1ac42" />

<img width="1897" height="1011" alt="Image" src="https://github.com/user-attachments/assets/cc0dd5bf-a100-4767-a8ca-df29c458589e" />

**7. Verify WAR File Generation**
   After a successful build, the .war file will be generated inside the target/ folder.

<img width="1562" height="608" alt="Image" src="https://github.com/user-attachments/assets/1ec94217-ccc0-4165-baf4-4c5f303de733" />

**8. Create a Deploy Server**
    Launch another EC2 instance for deployment.
    Use the same key pair (.pem) to connect.

<img width="1903" height="926" alt="Image" src="https://github.com/user-attachments/assets/aca43f63-07d7-4e44-9c82-b242c58a5e55" />

  Connect to server

<img width="1890" height="878" alt="Image" src="https://github.com/user-attachments/assets/f7a9e583-bbca-413a-ad4f-7393c97b3b2f" />

Copy the command

<img width="1898" height="881" alt="Image" src="https://github.com/user-attachments/assets/8fc371cd-a8b2-49f9-ac9f-f0f633dff972" />

Ensure that you can access the server terminal successfully.

<img width="1672" height="731" alt="Image" src="https://github.com/user-attachments/assets/c20997a1-f926-47ba-ac12-7e3f80db8dd7" />

**9. Install Java on the Deploy Server**
   sudo apt update
   sudo apt install openjdk-17-jdk -y

<img width="1292" height="683" alt="Image" src="https://github.com/user-attachments/assets/4108055e-d5bb-433e-8877-ed72ab5fd7d6" />

**10. Install and Set Up Tomcat**
      Download Apache Tomcat from the official website.
      Copy the download link address.

<img width="1911" height="925" alt="Image" src="https://github.com/user-attachments/assets/899d61c0-ed2a-4c17-be5b-fe680f0c4f30" />

     Use the following command to download it:
     wget "<Tomcat Download Link>"

<img width="1919" height="570" alt="Image" src="https://github.com/user-attachments/assets/10836fc3-3014-4bda-baaf-1cb1eba16875" />

**11. Extract Apache Tomcat**
     tar -xvzf apache-tomcat-9.0.110.tar.gz
     ls

<img width="1919" height="1014" alt="Image" src="https://github.com/user-attachments/assets/f1686edd-6509-4a68-a0a8-e58e43679865" />

**12. Start Tomcat Server**
The startup.sh script (found inside the bin/ folder) is used to start the server.

<img width="1918" height="777" alt="Image" src="https://github.com/user-attachments/assets/f9f644c5-f898-4ca5-81b7-ed35a7d6e784" />

**13. Access Tomcat in the Browser**

<img width="1892" height="927" alt="Image" src="https://github.com/user-attachments/assets/f3171714-25d3-4461-a4d6-771a2bac6862" />

     http://<DEPLOY_SERVER_IP>:8080

<img width="1907" height="983" alt="Image" src="https://github.com/user-attachments/assets/b71a46a3-06c5-4515-b0dc-7e9c23b78de5" />

    If the page doesn’t load, open port 8080 in the EC2 Security Group inbound rules, and then reload the page.
    In security Groups, edit the inbound rules:

<img width="1902" height="930" alt="Image" src="https://github.com/user-attachments/assets/6cf3715b-6692-4eed-9167-0626055c54cb" />

**14. Configure Tomcat Manager Access**

<img width="1910" height="977" alt="Image" src="https://github.com/user-attachments/assets/2d5b2abb-e32a-40e0-b4f5-951f1e46211e" />

    When you try to open Manager App, you may see a 403 Access Denied error.

<img width="1912" height="963" alt="Image" src="https://github.com/user-attachments/assets/3f14be8b-07a0-43b6-94ae-991fdefd3550" />

To fix this, edit the following two files:

**1.Context.xml**

Comment out or modify the RemoteAddrValve section to allow external IPs:
<!-- <Valve className="org.apache.catalina.valves.RemoteAddrValve"
       allow="127\.\d+\.\d+\.\d+|::1"/> -->

<img width="1920" height="1016" alt="Image" src="https://github.com/user-attachments/assets/48bf9b8e-fb5e-4377-bf79-1fcf4f2f578e" />

<img width="1552" height="762" alt="Image" src="https://github.com/user-attachments/assets/6149af92-3c34-47dc-a6f6-a90adefc4637" />

**2.tomcat-users.xml**

Add the following role and user credentials:
<role rolename="manager-gui"/>
<user username="admin" password="admin123" roles="manager-gui"/>

<img width="1902" height="980" alt="Image" src="https://github.com/user-attachments/assets/25b297fe-30df-4473-b74d-330f3a2e6f12" />

<img width="1918" height="918" alt="Image" src="https://github.com/user-attachments/assets/6e69a796-229f-4927-89f6-adfb779f520e" />

Save both files and restart Tomcat
./shutdown.sh
./startup.sh

**15. Access Tomcat Web Application Manager**

<img width="1918" height="1017" alt="Image" src="https://github.com/user-attachments/assets/f54e020b-9bfa-4d97-aa1a-92d3c39ba3a9" />

     After signing in, you can view the Tomcat Web Application Manager dashboard.

<img width="1917" height="956" alt="Image" src="https://github.com/user-attachments/assets/35a3792f-d9c1-480b-a14a-7e114d68bc9a" />

**16. Share PEM Key Between Servers**
     Copy your .pem file from your local machine to the build server:
     scp -i "book.pem" book.pem ubuntu@<BUILD_SERVER_IP>:~/

<img width="1918" height="1017" alt="Image" src="https://github.com/user-attachments/assets/5e755d24-18d6-4586-806b-4335cafa3b36" />

  Verify that the .pem file is copied successfully
  ls

<img width="1918" height="962" alt="Image" src="https://github.com/user-attachments/assets/fd27286c-d1f2-4061-a2a8-f1216a39e2a6" />

   Then set proper permissions:
   chmod 400 book.pem

<img width="1052" height="470" alt="Image" src="https://github.com/user-attachments/assets/1497efff-e25d-4d5f-8340-a2e47b835e74" />

**17. Deploy the WAR File from Build to Deploy Server**
      From the build server, transfer the .war file to the deploy server:
      scp -i book.pem /home/ubuntu/moviebooking/target/MovieBookingApp.war. ubuntu@<DEPLOY_SERVER_IP>:/home/ubuntu/apache-tomcat-          9.0.110/webapps/

<img width="1895" height="166" alt="Image" src="https://github.com/user-attachments/assets/deb2ee5b-3f7f-464f-b8bd-df25a42a7e8d" />

**18. Refresh Tomcat Manager**
Open Tomcat Manager again, and you should see your web application listed.

<img width="1998" height="1021" alt="Image" src="https://github.com/user-attachments/assets/69a23092-c5e8-45e1-9e86-368b49bf3df0" />

**19. Access the MovieBooking Application**
     Open in your browser:
     http://<DEPLOY_SERVER_IP>:8080/webapp
     Verify that the calculator application loads and functions properly.

<img width="1913" height="1015" alt="Image" src="https://github.com/user-attachments/assets/c4b1d5ed-e1f8-400a-9dd4-3f20ec96ff39" />
