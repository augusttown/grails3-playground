<!doctype html>
<html>
    <head>
    <meta name="layout" content="main"/>
    <title>Spring Security Keycloak Test</title>
    </head>
<body>
    <oauth2:connect provider="keycloak" id="google-connect-link">Keycloak</oauth2:connect>
    Logged with keycloak ?
    <oauth2:ifLoggedInWith provider="keycloak">yes</oauth2:ifLoggedInWith>
    <oauth2:ifNotLoggedInWith provider="keycloak">no</oauth2:ifNotLoggedInWith>
</body>
</html>
