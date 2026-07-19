/**
 * 
 */
package org.archcorner.codegen.django;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author bhagvan.kommadi
 *
 */
public class CodeGenerator {

	
	
	public void writeSettings(String path, String fileName, Map<String,String> databaseConfiguration)
	{
		
       CodeManager manager = new CodeManager();
		
		manager.createFile(path, fileName);
		
		String code = "import os\n";

		code = code + "# Build paths inside the project like this: os.path.join(BASE_DIR, ...)\n";
		
		code = code + "BASE_DIR = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))\n";


		code = code + "# Quick-start development settings - unsuitable for production\n";
		
		code = code + "# See https://docs.djangoproject.com/en/dev/howto/deployment/checklist/\n";

		code = code + "# SECURITY WARNING: keep the secret key used in production secret!\n";
		
		code = code + "SECRET_KEY = 'a#4(o9u+3nt@re@^xkozjmr-qb8o)593y#wu+!za+c)y68j(=%'\n";

		code = code + "# SECURITY WARNING: don't run with debug turned on in production!\n";
		code = code + "DEBUG = True\n";

		code = code + "ALLOWED_HOSTS = []\n";


		code = code + "# Application definition\n";

		code = code + "INSTALLED_APPS = [\n";
		code = code + "    'django.contrib.admin',\n";
		code = code + "    'django.contrib.auth', \n";
		code = code + "    'django.contrib.contenttypes',\n";
		code = code + "    'django.contrib.sessions', \n";
		code = code + "    'django.contrib.messages', \n";
		code = code + "    'django.contrib.staticfiles',\n";
		code = code + "]\n";

		code = code + "MIDDLEWARE = [\n";
		code = code + "    'django.middleware.security.SecurityMiddleware',\n";
		code = code + "    'django.contrib.sessions.middleware.SessionMiddleware',\n";
		code = code + "    'django.middleware.common.CommonMiddleware',\n";
		code = code + "    'django.middleware.csrf.CsrfViewMiddleware',\n";
		code = code + "    'django.contrib.auth.middleware.AuthenticationMiddleware',\n";
		code = code + "    'django.contrib.messages.middleware.MessageMiddleware',\n";
		code = code + "    'django.middleware.clickjacking.XFrameOptionsMiddleware',\n";
		code = code + "]\n";

		code = code + "ROOT_URLCONF = 'mysite.urls'\n";

		code = code + "TEMPLATES = [\n";
		code = code + "    {\n";
		code = code + "        'BACKEND': 'django.template.backends.django.DjangoTemplates',\n";
		code = code + "        'DIRS': [],\n";
		code = code + "        'APP_DIRS': True,\n";
		code = code + "        'OPTIONS': {\n";
		code = code + "            'context_processors': [\n";
		code = code + "                'django.template.context_processors.debug',\n";
		code = code + "                'django.template.context_processors.request',\n";
		code = code + "                'django.contrib.auth.context_processors.auth',\n";
		code = code + "                'django.contrib.messages.context_processors.messages',\n";
		code = code + "            ],\n";
		code = code + "        },\n";
		code = code + "    },\n";
		code = code + "]\n";

		code = code + "WSGI_APPLICATION = 'mysite.wsgi.application'\n";


		code = code + "# Database\n";
		code = code + "# https://docs.djangoproject.com/en/dev/ref/settings/#databases\n";

		code = code + "DATABASES = {\n";
		code = code + "    'default': {\n";
		code = code + "        'ENGINE': 'django.db.backends."+databaseConfiguration.get("ENGINE")+"',\n";
		code = code + "        'NAME': os.path.join(BASE_DIR, 'db."+databaseConfiguration.get("NAME")+"'),\n";
		code = code + "'USER': '"+databaseConfiguration.get("USER")+"',\n";
		code = code + "'PASSWORD': '"+databaseConfiguration.get("PASSWORD")+"',\n";
		code = code + "'HOST': '"+databaseConfiguration.get("HOST")+"',\n";
		code = code + "'PORT': '"+databaseConfiguration.get("PORT")+"',\n";
		code = code + "    }\n";
		code = code + "}\n";


		code = code + "# Password validation\n";
		code = code + "# https://docs.djangoproject.com/en/dev/ref/settings/#auth-password-validators\n";

		code = code + "AUTH_PASSWORD_VALIDATORS = [\n";
		code = code + "    {\n";
		code = code + "        'NAME': 'django.contrib.auth.password_validation.UserAttributeSimilarityValidator',\n";
		code = code + "    },\n";
		code = code + "    {\n";
		code = code + "        'NAME': 'django.contrib.auth.password_validation.MinimumLengthValidator',\n";
		code = code + "    },\n";
		code = code + "    { \n";
	    code = code + "        'NAME': 'django.contrib.auth.password_validation.CommonPasswordValidator',\n";
	    code = code + "    },\n";
	    code = code + "    { \n";
	    code = code + "        'NAME': 'django.contrib.auth.password_validation.NumericPasswordValidator',\n";
	    code = code + "    },\n";
	    code = code + "]\n";


	    code = code + "# Internationalization\n";
	    code = code + "# https://docs.djangoproject.com/en/dev/topics/i18n/\n";

	    code = code + "LANGUAGE_CODE = 'en-us'\n";

	    code = code + "TIME_ZONE = 'UTC'\n";

	    code = code + "USE_I18N = True\n";

	    code = code + "USE_L10N = True\n";

	    code = code + "USE_TZ = True\n";


	    code = code + "# Static files (CSS, JavaScript, Images)\n";
	    code = code + "# https://docs.djangoproject.com/en/dev/howto/static-files/\n";

	    code = code + "STATIC_URL = '/static/'\n";

        manager.writeCode(code);
		
		manager.closeClass();
	}
	
	public void writeViews(String path, String fileName, String message)
	{
	     
		
		CodeManager manager = new CodeManager();
		
		manager.createFile(path, fileName);
		
		String code = "from django.http import HttpResponse\n";
		
		code = code + "def index(request):\n";
		
		
		code = code + " return HttpResponse(\""+ message+"\")";
		
		manager.writeCode(code);
		
		manager.closeClass();
	}
	
	
	public void writeUrls(String path, String fileName)
	{
		
       CodeManager manager = new CodeManager();
		
		manager.createFile(path, fileName);
		
		
		
		String code = "from django.urls import path\n";

		code = code + "from . import views\n";

		code = code + "urlpatterns = [\n";
		code = code +  "path('', views.index, name='index'),\n";
		code = code + "]\n";
		
        manager.writeCode(code);
		
		manager.closeClass();
		
		
	}
	public void writeUrls(String path, String fileName, List<String> urlPaths, List<String> urlPatterns)
	{
	     
		
		CodeManager manager = new CodeManager();
		
		manager.createFile(path, fileName);
		
		
		
		String code = "from django.urls import include, path\n";
		code = code + "from django.contrib import admin\n";

		code = code + "urlpatterns = [\n";
		
		for(int i=0; i < urlPaths.size(); i++)
		{
			String urlPath = urlPaths.get(i);
			String urlPattern = urlPatterns.get(i);
			
			code = code + "path('"+ urlPath+"/', "+urlPattern+"),\n";
			
		}
		
		code =  code + "]\n";
		manager.writeCode(code);
		
		manager.closeClass();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		CodeGenerator generator = new CodeGenerator();
		
		String message = "Hello, world. You're at the polls main.";
		
		generator.writeViews("/Users/bhagvan.kommadi/Documents/AIPredict/GoldenRod/mysite/polls", "views", message);
		
		
		generator.writeUrls("/Users/bhagvan.kommadi/Documents/AIPredict/GoldenRod/mysite/polls","urls");
		
		List<String> urlPaths = new ArrayList();
		
		urlPaths.add("polls");
		urlPaths.add("admin");
		
		List<String> urlPatterns = new ArrayList();
		urlPatterns.add("include('polls.urls')");
		urlPatterns.add("admin.site.urls");
		generator.writeUrls("/Users/bhagvan.kommadi/Documents/AIPredict/GoldenRod/mysite/mysite","urls", urlPaths,urlPatterns);
		
		Map<String,String> map = new HashMap();
		map.put("ENGINE", "mysql");
		map.put("NAME", "mydatabase");
		map.put("USER", "root");
		map.put("PASSWORD", "root");
		map.put("HOST", "127.0.0.1");
		map.put("PORT", "3306");
		generator.writeSettings("/Users/bhagvan.kommadi/Documents/AIPredict/GoldenRod/mysite/mysite","settings",map);
		
	}

}
