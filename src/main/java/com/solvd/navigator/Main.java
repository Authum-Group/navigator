package com.solvd.navigator;

import com.solvd.navigator.domain.*;
import com.solvd.navigator.service.PointService;
import com.solvd.navigator.service.impl.PointServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws Exception {

        Coordinate coordinate  = new Coordinate();
        coordinate.setLatitude(53.902738);
        coordinate.setLongitude(27.573555);

        House house  = new House();
        house.setNumber(15L);
        house.setBlock("2A");
        house.setNumberOfEntrances(8L);
        List<House> houses = new ArrayList<>();
        houses.add(house);

        Street street = new Street();
        street.setName("Independence street");
        street.setHouses(houses);

        Country country = new Country();
        country.setName("Belarus");

        Region region = new Region();
        region.setName("Minsk region");
        region.setCountry(country);
        List<Region> regions = new ArrayList<>();
        regions.add(region);

        country.setRegions(regions);

        City city = new City();
        city.setName("Minsk");
        city.setRegion(region);

        District district = new District();
        district.setCity(city);
        district.setName("Central");
        List<District> districts = new ArrayList<>();
        districts.add(district);

        city.setDistricts(districts);

        Point point = new Point();
        point.setCoordinate(coordinate);
        point.setDistrict(district);
        point.setName("Gorky park");
        point.setStreet(street);
        point.setType(Point.Type.PUBLIC_PLACE);

        PointService pointService = new PointServiceImpl();

        LOGGER.info("Hello! Please, enter the address of the route start point");
        Scanner scanner = new Scanner(System.in);
        String point1 = scanner.nextLine();
        Long idI = pointService.getIdByName(point1);

        LOGGER.info("Enter Destination");
        point1 = scanner.nextLine();
        Long idJ = pointService.getIdByName(point1);
    }
}
