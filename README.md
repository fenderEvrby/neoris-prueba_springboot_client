---------------Endpoints publicos -----------
Api pokemón
http://127.0.0.1:8080/api/pokemon/ditto

Encriptación
http://127.0.0.1:8080/api/encriptar/ruben

---------------Endpoints protegidos -----------
POST: http://127.0.0.1:8080/login/oauth2/code/client-app
      http://127.0.0.1:9000/login
      Body - Form-data: Username: ruben.aquino
                        Password: contra.123
                        
POST: http://127.0.0.1:9000/oauth2/token
      Authorization - Type: Basic auth
                            Username: client-app
                            Password: contra.123
      Body: form-data:  code: código obtenido del endpoint login
                        grant_type: authorization_code
                        redirect_uri: http://127.0.0.1:8080/authorized
                        
POST: http://127.0.0.1:8080/api/items
      Authorization - Type: Bearer Token
                      Token: El obtenido del endopoint token
      Body: {
              "nombre": "ruben"
            }
GET: http://127.0.0.1:8080/api/items
      Authorization - Type: Bearer Token
                      Token: El obtenido del endopoint token
GET: http://127.0.0.1:8080/api/items/ruben
      Authorization - Type: Bearer Token
                      Token: El obtenido del endopoint token
