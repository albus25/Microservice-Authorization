# Microservice-Authorization
 JWT Authorization with Static Credentials in MicroService

Client App:
<dependency>
	 <groupId>io.vertx</groupId>
	 <artifactId>vertx-auth-jwt</artifactId>
  <version>3.8.1</version>
</dependency>
-Add this dependency in pom.xml at client application
-Put privatekey.pem in OtherSources
-Copy & Paste GenerateJoken and MPJWTToken in Source Packages
-Change:
 subject = "<enter_username>";
	groups = new ArrayList<>();
	groups.add("<enter_rolename>"); in GenerateJoken
-Add @ClientHeaderParam(name="Authorization",value="{generateJWTToken}") and
-Add method in interface:
	default String generateJWTToken() {
		String token = GenerateToken.generateJWT();
		return "Bearer " + token;
	} in ClientFile

Service App:
-Put publickey.pem in OtherSources
-Create Property file and named it "payara-mp-jwt" in OtherSources and write:
	accepted.issuer = https://server.example.com
-Create Annotation in BootStrap.java:
	@LoginConfig(authMethod = "MP-JWT")
	@DeclareRoles({"Admin","User"})
-Add @RolesAllowed("<role_name>") in ServiceFile
