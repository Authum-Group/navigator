package com.solvd.navigator;

import com.solvd.navigator.domain.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

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
    }
}
