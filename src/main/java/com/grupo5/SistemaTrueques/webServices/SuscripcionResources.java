package com.grupo5.SistemaTrueques.webServices;

import com.grupo5.SistemaTrueques.EnviarCorreo;
import com.grupo5.SistemaTrueques.dao.SuscripcionDAO;
import com.grupo5.SistemaTrueques.entities.Suscripcion;
import com.grupo5.SistemaTrueques.entities.SuscripcionNormal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.TimeUnit;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/suscripcion")
public class SuscripcionResources {
    @Autowired
    SuscripcionDAO suscripcionDAO;
    @Autowired
    EnviarCorreo enviarCorreo;

    @RequestMapping(value = "/all/{noticia}", method = RequestMethod.GET) //READ-LEER
    public List<Suscripcion> obtenerLista (@PathVariable ("noticia")String noticia){
        String web1 = "<!doctype html>\n" +
                "<html lang=\"en\"><head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
                "    <meta name=\"description\" content=\"\">\n" +
                "    <meta name=\"author\" content=\"Mark Otto, Jacob Thornton, and Bootstrap contributors\">\n" +
                "    <meta name=\"generator\" content=\"Jekyll v4.1.1\">\n" +
                "    <title>Cover Template · Bootstrap</title>\n" +
                "\n" +
                "    <link rel=\"canonical\" href=\"https://getbootstrap.com/docs/4.5/examples/cover/\">\n" +
                "\n" +
                "    <!-- Bootstrap core CSS -->\n" +
                "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\">\n" +
                "\n" +
                "\n" +
                "    <style>\n" +
                "      .bd-placeholder-img {\n" +
                "        font-size: 1.125rem;\n" +
                "        text-anchor: middle;\n" +
                "        -webkit-user-select: none;\n" +
                "        -moz-user-select: none;\n" +
                "        -ms-user-select: none;\n" +
                "        user-select: none;\n" +
                "      }\n" +
                "\n" +
                "      @media (min-width: 768px) {\n" +
                "        .bd-placeholder-img-lg {\n" +
                "          font-size: 3.5rem;\n" +
                "        }\n" +
                "      }\n" +
                "\t  body{\n" +
                "\t\tbackground:black;\n" +
                "\t\t   \n" +
                "    color: white;\n" +
                "\t  }\n" +
                "    </style>\n" +
                "    <!-- Custom styles for this template -->\n" +
                "    <link href=\"cover.css\" rel=\"stylesheet\">\n" +
                "  </head>\n" +
                "  <body class=\"text-center\">\n" +
                "    <div class=\"cover-container d-flex w-100 h-100 p-3 mx-auto flex-column\">\n" +
                "  <header class=\"masthead mb-auto\">\n" +
                "    <div class=\"inner\">\n" +
                "      <h3 class=\"masthead-brand\">Trueques Galaxia</h3>\n" +
                "      <nav class=\"nav nav-masthead justify-content-center\">\n" +
                "        \n" +
                "      </nav>\n" +
                "    </div>\n" +
                "  </header>\n" +
                "\n" +
                "  <main role=\"main\" class=\"inner cover\">\n" +
                "    <h1 class=\"cover-heading\">Noticias</h1>\n" +
                "    <p class=\"lead\">"+noticia+"</p>\n" +
                "    <p class=\"lead\">\n" +
                "      <a href=\"http://localhost:4200/#\" class=\"btn btn-danger\">Trocar</a>\n" +
                "    </p>\n" +
                "  </main>\n" +
                "\n" +
                "  <footer class=\"mastfoot mt-auto\">\n" +
                "    <div class=\"inner\">\n" +
                "     <div id=\"bottom-footer\" class=\"section\">\n" +
                "        <div class=\"container\">\n" +
                "            <!-- row -->\n" +
                "            <div class=\"row\">\n" +
                "                <div class=\"col-md-12 text-center\">\n" +
                "                    <span class=\"copyright\">\n" +
                "                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->\n" +
                "                        <i class=\"fa fa-heart-o\" aria-hidden=\"true\"></i> Trueques Galaxia &copy; 2020 All rights reserved\n" +
                "                        <i class=\"fa fa-heart-o\" aria-hidden=\"true\"></i>\n" +
                "                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->\n" +
                "                    </span>\n" +
                "\n" +
                "                    <img src=\"https://lh3.googleusercontent.com/-vUx8lnvrXH4/X2kATzYBnrI/AAAAAAAAKJM/o7zOB4jY21wz716ztY2VR4bschTqYlNRgCNcBGAsYHQ/logoo.png\" alt=\"imagen\" class=\"png\" width=\"100px\">\n" +
                "\n" +
                "\n" +
                "\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <!-- /row -->\n" +
                "        </div>\n" +
                "        <!-- /container -->\n" +
                "    </div>\n" +
                "    </div>\n" +
                "  </footer>\n" +
                "</div>\n" +
                "</body>";
        enviarCorreo.enviarSuscripcionAtodos(suscripcionDAO.suscripcionList().toString(),"Noticias",web1);
        return suscripcionDAO.suscripcionList();
    }
    @RequestMapping( method = RequestMethod.GET) //READ-LEER
    public List<SuscripcionNormal> obtenerListaNormal (){
        return suscripcionDAO.suscripcionNormal();
    }
    @RequestMapping(value = "/{correo}", method = RequestMethod.DELETE)
    public int eliminar(@PathVariable("correo") String correo){
        String web1 = "<!doctype html>\n" +
                "<html lang=\"en\"><head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
                "    <meta name=\"description\" content=\"\">\n" +
                "    <meta name=\"author\" content=\"Mark Otto, Jacob Thornton, and Bootstrap contributors\">\n" +
                "    <meta name=\"generator\" content=\"Jekyll v4.1.1\">\n" +
                "    <title>Cover Template · Bootstrap</title>\n" +
                "\n" +
                "    <link rel=\"canonical\" href=\"https://getbootstrap.com/docs/4.5/examples/cover/\">\n" +
                "\n" +
                "    <!-- Bootstrap core CSS -->\n" +
                "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\">\n" +
                "\n" +
                "\n" +
                "    <style>\n" +
                "      .bd-placeholder-img {\n" +
                "        font-size: 1.125rem;\n" +
                "        text-anchor: middle;\n" +
                "        -webkit-user-select: none;\n" +
                "        -moz-user-select: none;\n" +
                "        -ms-user-select: none;\n" +
                "        user-select: none;\n" +
                "      }\n" +
                "\n" +
                "      @media (min-width: 768px) {\n" +
                "        .bd-placeholder-img-lg {\n" +
                "          font-size: 3.5rem;\n" +
                "        }\n" +
                "      }\n" +
                "\t  body{\n" +
                "\t\tbackground:black;\n" +
                "\t\t   \n" +
                "    color: white;\n" +
                "\t  }\n" +
                "    </style>\n" +
                "    <!-- Custom styles for this template -->\n" +
                "    <link href=\"cover.css\" rel=\"stylesheet\">\n" +
                "  </head>\n" +
                "  <body class=\"text-center\">\n" +
                "    <div class=\"cover-container d-flex w-100 h-100 p-3 mx-auto flex-column\">\n" +
                "  <header class=\"masthead mb-auto\">\n" +
                "    <div class=\"inner\">\n" +
                "      <h3 class=\"masthead-brand\">Trueques Galaxia</h3>\n" +
                "      <nav class=\"nav nav-masthead justify-content-center\">\n" +
                "        \n" +
                "      </nav>\n" +
                "    </div>\n" +
                "  </header>\n" +
                "\n" +
                "  <main role=\"main\" class=\"inner cover\">\n" +
                "    <h1 class=\"cover-heading\">Hasta pronto ... </h1>\n" +
                "    <p class=\"lead\">Lamentamos que te vayas , te estaremos esperando :) , Equipo Trueques Galaxy's</p>\n" +
                "    <p class=\"lead\">\n" +
                "      <a href=\"http://localhost:4200/#\" class=\"btn btn-danger\">Trocar</a>\n" +
                "    </p>\n" +
                "  </main>\n" +
                "\n" +
                "  <footer class=\"mastfoot mt-auto\">\n" +
                "    <div class=\"inner\">\n" +
                "     <div id=\"bottom-footer\" class=\"section\">\n" +
                "        <div class=\"container\">\n" +
                "            <!-- row -->\n" +
                "            <div class=\"row\">\n" +
                "                <div class=\"col-md-12 text-center\">\n" +
                "                    <span class=\"copyright\">\n" +
                "                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->\n" +
                "                        <i class=\"fa fa-heart-o\" aria-hidden=\"true\"></i> Trueques Galaxia &copy; 2020 All rights reserved\n" +
                "                        <i class=\"fa fa-heart-o\" aria-hidden=\"true\"></i>\n" +
                "                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->\n" +
                "                    </span>\n" +
                "\n" +
                "                    <img src=\"https://lh3.googleusercontent.com/-vUx8lnvrXH4/X2kATzYBnrI/AAAAAAAAKJM/o7zOB4jY21wz716ztY2VR4bschTqYlNRgCNcBGAsYHQ/logoo.png\" alt=\"imagen\" class=\"png\" width=\"100px\">\n" +
                "\n" +
                "\n" +
                "\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <!-- /row -->\n" +
                "        </div>\n" +
                "        <!-- /container -->\n" +
                "    </div>\n" +
                "    </div>\n" +
                "  </footer>\n" +
                "</div>\n" +
                "</body>";
        enviarCorreo.enviarConGMail(correo,"Trueques galaxia ...",web1);
        return suscripcionDAO.eliminarSuscripcion(correo);
    }
    @RequestMapping(method = RequestMethod.POST) //CREAR-CREATE
    public int newSub (@RequestBody SuscripcionNormal suscripcion) {
        return suscripcionDAO.nuevaSub(suscripcion);

    }
    @RequestMapping(value = "/envio/{correo}")
    public int EnvioEmail (@PathVariable("correo") String correo){
        String web1 = "<!doctype html>\n" +
                "<html lang=\"en\"><head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
                "    <meta name=\"description\" content=\"\">\n" +
                "    <meta name=\"author\" content=\"Mark Otto, Jacob Thornton, and Bootstrap contributors\">\n" +
                "    <meta name=\"generator\" content=\"Jekyll v4.1.1\">\n" +
                "    <title>Cover Template · Bootstrap</title>\n" +
                "\n" +
                "    <link rel=\"canonical\" href=\"https://getbootstrap.com/docs/4.5/examples/cover/\">\n" +
                "\n" +
                "    <!-- Bootstrap core CSS -->\n" +
                "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\">\n" +
                "\n" +
                "\n" +
                "    <style>\n" +
                "      .bd-placeholder-img {\n" +
                "        font-size: 1.125rem;\n" +
                "        text-anchor: middle;\n" +
                "        -webkit-user-select: none;\n" +
                "        -moz-user-select: none;\n" +
                "        -ms-user-select: none;\n" +
                "        user-select: none;\n" +
                "      }\n" +
                "\n" +
                "      @media (min-width: 768px) {\n" +
                "        .bd-placeholder-img-lg {\n" +
                "          font-size: 3.5rem;\n" +
                "        }\n" +
                "      }\n" +
                "\t  body{\n" +
                "\t\tbackground:black;\n" +
                "\t\t   \n" +
                "    color: white;\n" +
                "\t  }\n" +
                "    </style>\n" +
                "    <!-- Custom styles for this template -->\n" +
                "    <link href=\"cover.css\" rel=\"stylesheet\">\n" +
                "  </head>\n" +
                "  <body class=\"text-center\">\n" +
                "    <div class=\"cover-container d-flex w-100 h-100 p-3 mx-auto flex-column\">\n" +
                "  <header class=\"masthead mb-auto\">\n" +
                "    <div class=\"inner\">\n" +
                "      <h3 class=\"masthead-brand\">Trueques Galaxia</h3>\n" +
                "      <nav class=\"nav nav-masthead justify-content-center\">\n" +
                "        \n" +
                "      </nav>\n" +
                "    </div>\n" +
                "  </header>\n" +
                "\n" +
                "  <main role=\"main\" class=\"inner cover\">\n" +
                "    <h1 class=\"cover-heading\">Bienvenido a Trueques Galaxia</h1>\n" +
                "    <p class=\"lead\">Ahora recibiras noticias de nuestra pagina web :) </p>\n" +
                "    <p class=\"lead\">\n" +
                "      <a href=\"http://localhost:4200/#\" class=\"btn btn-danger\">Trocar</a>\n" +
                "    </p>\n" +
                "  </main>\n" +
                "\n" +
                "  <footer class=\"mastfoot mt-auto\">\n" +
                "    <div class=\"inner\">\n" +
                "     <div id=\"bottom-footer\" class=\"section\">\n" +
                "        <div class=\"container\">\n" +
                "            <!-- row -->\n" +
                "            <div class=\"row\">\n" +
                "                <div class=\"col-md-12 text-center\">\n" +
                "                    <span class=\"copyright\">\n" +
                "                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->\n" +
                "                        <i class=\"fa fa-heart-o\" aria-hidden=\"true\"></i> Trueques Galaxia &copy; 2020 All rights reserved\n" +
                "                        <i class=\"fa fa-heart-o\" aria-hidden=\"true\"></i>\n" +
                "                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->\n" +
                "                    </span>\n" +
                "\n" +
                "                    <img src=\"https://lh3.googleusercontent.com/-vUx8lnvrXH4/X2kATzYBnrI/AAAAAAAAKJM/o7zOB4jY21wz716ztY2VR4bschTqYlNRgCNcBGAsYHQ/logoo.png\" alt=\"imagen\" class=\"png\" width=\"100px\">\n" +
                "\n" +
                "\n" +
                "\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <!-- /row -->\n" +
                "        </div>\n" +
                "        <!-- /container -->\n" +
                "    </div>\n" +
                "    </div>\n" +
                "  </footer>\n" +
                "</div>\n" +
                "</body>";
        enviarCorreo.enviarConGMail(correo,"Bienvenido a trueques galaxia",web1);
        return 1;
    }
}
