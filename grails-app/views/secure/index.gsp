<!doctype html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Spring Security Keycloak Test - Secured Resource</title>
    </head>
    <body>
        <oauth2:connect provider="keycloak" id="google-connect-link">Keycloak</oauth2:connect>
        Authenticated through Keycloak?
        <oauth2:ifLoggedInWith provider="keycloak">Yes</oauth2:ifLoggedInWith>
        <oauth2:ifNotLoggedInWith provider="keycloak">No</oauth2:ifNotLoggedInWith>
    </body>
</html>
