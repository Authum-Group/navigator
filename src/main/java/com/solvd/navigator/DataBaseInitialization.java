package com.solvd.navigator;

import com.solvd.navigator.domain.*;
import com.solvd.navigator.domain.exception.EntityNotValidException;
import com.solvd.navigator.domain.exception.InvalidParametersException;
import com.solvd.navigator.domain.exception.ResourceNotFoundException;
import com.solvd.navigator.service.*;
import com.solvd.navigator.service.impl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class DataBaseInitialization {

    public static final Logger LOGGER = LogManager.getLogger(DataBaseInitialization.class);

    public static void initialize() {
        List<Country> countries = Arrays.asList(
                createCountry("Республика Беларусь")
        );

        List<Region> regions = Arrays.asList(
                createRegion(countries.get(0), "Могилевская область"),
                createRegion(countries.get(0), "Брестская область"),
                createRegion(countries.get(0), "Минская область"),
                createRegion(countries.get(0), "Гомельcкая область"),
                createRegion(countries.get(0), "Гродненская область"),
                createRegion(countries.get(0), "Витебская область")
        );

        List<City> cities = Arrays.asList(
                createCity(regions.get(2), "Минск")
        );

        List<District> districts = Arrays.asList(
                createDistrict(cities.get(0), "Фрунзенский район"),
                createDistrict(cities.get(0), "Центральный район"),
                createDistrict(cities.get(0), "Минский район"),
                createDistrict(cities.get(0), "Ленинский район"),
                createDistrict(cities.get(0), "Советский район")
        );

        List<Street> streets = Arrays.asList(
                createStreet(districts.get(0), "ул. Притыцкого"),
                createStreet(districts.get(1), "пр-т. Победителей"),
                createStreet(districts.get(2), "МКАД"),
                createStreet(districts.get(3), "ул. Ташкентская"),
                createStreet(districts.get(3), "пр-т. Рокоссовкого"),
                createStreet(districts.get(4), "ул. Кольцова")
        );

        List<PointType> pointTypes = Arrays.asList(
                createPointType("Арена"),
                createPointType("Торговый центр"),
                createPointType("Аквапарк"),
                createPointType("Спортивный комплекс")
        );

        List<Point> points = Arrays.asList(
                createPoint("дом 156, GREEN", 53.91021, 27.43475, streets.get(0), pointTypes.get(1), "Хорошее место для отдыха. Чижовка Арена была построена для проведения чемпионата мира по хоккею."),
                createPoint("дом 120, Лебяжий", 53.95589, 27.45121, streets.get(1), pointTypes.get(2), "Большой аквапарк с крытыми и открытыми горками, бассейнами, \"медленной рекой\", спа и залом игровых автоматов."),
                createPoint("50-й км, EXPOBEL", 53.96811, 27.62250, streets.get(2), pointTypes.get(1), "Торговый центр с разнообразными магазинами и киосками, ресторанами быстрого питания и гипермаркетом BIGZZ."),
                createPoint("дом 19 ЧИЖОВКА-АРЕНА", 53.84736, 27.62559, streets.get(3), pointTypes.get(3), null),
                createPoint("дом 44 Теннисный центр", 53.87045, 27.58989, streets.get(4), pointTypes.get(3), null),
                createPoint("дом 6 Теннисный клуб", 53.96302, 27.59375, streets.get(5), pointTypes.get(3), null)
        );

        List<Transition> transitions = Arrays.asList(
                createTransition(points.get(1), points.get(5)),
                createTransition(points.get(0), points.get(5)),
                createTransition(points.get(0), points.get(4)),
                createTransition(points.get(4), points.get(0)),
                createTransition(points.get(5), points.get(2)),
                createTransition(points.get(4), points.get(2)),
                createTransition(points.get(4), points.get(3)),
                createTransition(points.get(2), points.get(3))
        );

        /**
         *  Country CRUD (WORK)
         */
        try {
            CountryService countryService = new CountryServiceImpl();
            countries.stream()
                    .forEach(country -> {
                        try {
                            countryService.create(country);
                        } catch (InvalidParametersException | EntityNotValidException | ResourceNotFoundException ex) {
                            LOGGER.error("Exception when try to initialise database by countries");
                        }
                    });

            countries = countryService.findAll();

            Country oneCountry = countryService.findById(countries.get(1).getId());

            oneCountry.setName("MODIFIED");

            countryService.update(oneCountry);
            // countryService.delete(oneCountry);

            /**
             *  Region CRUD
             */
            RegionService regionService = new RegionServiceImpl();
            regions.stream()
                    .forEach(region -> {
                        try {
                            regionService.create(region, oneCountry.getId());
                        } catch (InvalidParametersException | EntityNotValidException | ResourceNotFoundException ex) {
                            LOGGER.error("Exception when try to initialise database by regions");
                        }
                    });

            List<Region> allRegions = regionService.findAll();

            Region oneRegion = regionService.findById(allRegions.get(1).getId());

            oneRegion.setName("MODIFIED");

            regionService.update(oneRegion);
            //regionService.delete(oneRegion);

            /**
             *  City CRUD
             */
            CityService cityService = new CityServiceImpl();
            cities.stream()
                    .forEach(city -> {
                        try {
                            cityService.create(city, oneRegion.getId());
                        } catch (InvalidParametersException | EntityNotValidException | ResourceNotFoundException ex) {
                            LOGGER.error("Exception when try to initialise database by cities");
                        }
                    });

            List<City> allCities = cityService.findAll();

            City oneCity = cityService.findById(allCities.get(1).getId());

            oneCity.setName("MODIFIED");

            cityService.update(oneCity);
            //cityService.delete(oneCity);

            /**
             * District  CRUD
             */
            DistrictService districtService = new DistrictServiceImpl();
            districts.stream()
                    .forEach(district -> {
                        try {
                            districtService.create(district, oneCity.getId());
                        } catch (InvalidParametersException | EntityNotValidException | ResourceNotFoundException ex) {
                            LOGGER.error("Exception when try to initialise database by districts");
                        }
                    });

            List<District> allDistricts = districtService.findAll();

            District oneDistrict = districtService.findById(allDistricts.get(1).getId());

            oneDistrict.setName("MODIFIED");

            districtService.update(oneDistrict);
            //districtService.delete(oneDistrict);

            /**
             * Street  CRUD
             */
            StreetService streetService = new StreetServiceImpl();
            streets.stream()
                    .forEach(street -> {
                        try {
                            streetService.create(street, oneDistrict.getId());
                        } catch (InvalidParametersException | EntityNotValidException | ResourceNotFoundException ex) {
                            LOGGER.error("Exception when try to initialise database by streets");
                        }
                    });

            List<Street> allStreets = streetService.findAll();

            Street oneStreet = streetService.findById(allStreets.get(1).getId());

            oneStreet.setName("MODIFIED");

            streetService.update(oneStreet);
            //streetService.delete(oneStreet);

            /**
             *  PointType CRUD
             */
            PointTypeService pointTypeService = new PointTypeServiceImpl();
            pointTypes.stream()
                    .forEach(pointType -> {
                        try {
                            pointTypeService.create(pointType);
                        } catch (InvalidParametersException | EntityNotValidException | ResourceNotFoundException ex) {
                            LOGGER.error("Exception when try to initialise database by point types");
                        }
                    });
            List<PointType> allPointTypes = pointTypeService.findAll();
            PointType onePointType = pointTypeService.findById(allPointTypes.get(1).getId());
            onePointType.setName("MODIFIED");
            pointTypeService.update(onePointType);
            //pointTypeService.delete(onePointType);

            /**
             *  Point CRUD
             */
            PointService pointService = new PointServiceImpl();
            points.stream()
                    .forEach(point -> {
                        try {
                            pointService.create(point, oneStreet.getId());
                        } catch (InvalidParametersException | EntityNotValidException | ResourceNotFoundException ex) {
                            LOGGER.error("Exception when try to initialise database by points");
                        }
                    });

            List<Point> allPoints = pointService.findAll();

            Point onePoint = pointService.findById(allPoints.get(1).getId());

            onePoint.setName("MODIFIED");

            pointService.update(onePoint);
            //pointService.delete(onePoint);

            /**
             * Transition  CRUD
             */
            TransitionService transitionService = new TransitionServiceImpl();
            transitions.stream()
                    .forEach(transition -> {
                        try {
                            transitionService.create(transition);
                        } catch (InvalidParametersException | EntityNotValidException ex) {
                            LOGGER.error("Exception when try to initialise database by transitions");
                        }
                    });

            List<Transition> allTransitions = transitionService.findAll();

            Transition oneTransition = transitionService.findById(allTransitions.get(1).getId());

            oneTransition.setTo(allPoints.get(2));

            transitionService.update(oneTransition);
            //transitionService.delete(oneTransition);

        } catch (EntityNotValidException | InvalidParametersException |
                ResourceNotFoundException ex) {
            LOGGER.error(ex);
        }

    }

    private static Country createCountry(String name) {
        Country country = new Country();
        country.setName(name);
        return country;
    }

    private static Region createRegion(Country country, String name) {
        Region region = new Region();
        region.setCountry(country);
        region.setName(name);
        return region;
    }

    private static City createCity(Region region, String name) {
        City city = new City();
        city.setRegion(region);
        city.setName(name);
        return city;
    }

    private static District createDistrict(City city, String name) {
        District district = new District();
        district.setCity(city);
        district.setName(name);
        return district;
    }

    private static Street createStreet(District district, String name) {
        Street street = new Street();
        street.setDistrict(district);
        street.setName(name);
        return street;
    }

    private static PointType createPointType(String name) {
        PointType pointType = new PointType();
        pointType.setName(name);
        return pointType;
    }

    private static Point createPoint(String name, Double longitude, Double latitude, Street street, PointType type, String description) {
        Point point = new Point();
        point.setName(name);
        point.setLongitude(longitude);
        point.setLatitude(latitude);
        point.setStreet(street);
        point.setType(type);
        point.setDescription(description);
        return point;
    }

    private static Transition createTransition(Point from, Point to) {
        Transition transition = new Transition();
        transition.setFrom(from);
        transition.setTo(to);
        return transition;
    }
}
