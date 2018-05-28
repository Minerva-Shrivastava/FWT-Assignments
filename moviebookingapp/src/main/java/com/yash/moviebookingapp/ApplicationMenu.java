package com.yash.moviebookingapp;

import java.util.Scanner;

import com.yash.moviebookingapp.dao.MovieDAO;
import com.yash.moviebookingapp.dao.ScreenDAO;
import com.yash.moviebookingapp.daoimpl.MovieDAOImpl;
import com.yash.moviebookingapp.daoimpl.ScreenDAOImpl;
import com.yash.moviebookingapp.model.Screen;
import com.yash.moviebookingapp.service.MovieService;
import com.yash.moviebookingapp.service.ScreenService;
import com.yash.moviebookingapp.serviceimpl.MovieServiceImpl;
import com.yash.moviebookingapp.serviceimpl.ScreenServiceImpl;
import com.yash.moviebookingapp.util.FileUtil;

public class ApplicationMenu {

	Scanner input;
	public void getMenu() {

		input=new Scanner(System.in);
		FileUtil fileUtil = new FileUtil();
		ScreenDAO screenDAO = new ScreenDAOImpl();
		ScreenService screenService = new ScreenServiceImpl(screenDAO);
		MovieDAO movieDAO = new MovieDAOImpl();
		MovieService movieService = new MovieServiceImpl(movieDAO);
		
		String choice;
		int menuChoice;
		do {
			fileUtil.readMenu("mainMenu.txt");
			menuChoice = input.nextInt();
			switch (menuChoice) {
			case 1:
				System.out.println("Enter Screen id: ");
				Screen screen = new Screen();
				int id = input.nextInt();
				screen.setId(id);
				input.nextLine();
				System.out.println("Enter screen name");
				String screenName=input.next();
				screen.setName(screenName);
				System.out.println(screen+"is added");
				screenService.addScreen(screen);
				break;

			case 2:
				System.out.println("Enter Screen on which you want to add movie : ");
				String screen1=input.nextLine();
				System.out.println("Enter movie details");
				
				break;
				
			default:
				break;
			}
			System.out.println("Do you want to continue..?");
			choice=input.next();
		} while (choice.equalsIgnoreCase("Yes"));
		}

}
