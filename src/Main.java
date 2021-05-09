import adapter.MernisServiceAdapter;
import business.abstracts.*;
import business.concretes.*;
import dataAccess.concretes.*;
import entities.concretes.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        // here comes the cirkin code
        PlatformService platformService = new PlatformManager(new InMemoryPlatformDao());
        GenreService genreService = new GenreManager(new InMemoryGenreDao());
        GameService gameService = new GameManager(new InMemoryGameDao());
        DiscountRatioService discountRatioService = new DiscountRatioManager(new InMemoryDiscountRatioDao());
        DiscountAmountService discountAmountService = new DiscountAmountManager(new InMemoryDiscountAmountDao());
        PlayerService playerService = new PlayerManager(new InMemoryPlayerDao());
        CitizenPlayerService citizenPlayerService = new CitizenPlayerManager(new InMemoryCitizenPlayerDao(), new MernisServiceAdapter());
        UserService userService = new UserManager(new InMemoryUserDao());
        ShoppingCartService shoppingCartService = new ShoppingCartManager(new InMemoryShoppingCartDao());
        // here ends the cirkin code

        // here is example of dummy data
        userService.add(new User(1, "enes@test.com", "password"));
        userService.add(new User(2, "tstark@test.com", "password"));
        userService.add(new User(3, "srogers@test.com", "password"));
        citizenPlayerService.add(new CitizenPlayer(1, 1, "Enes", "Yilmaz", LocalDate.of(1998, Calendar.MARCH, 28), 0, "00000000000"));
        citizenPlayerService.add(new CitizenPlayer(2, 2, "Tony", "Stark", LocalDate.of(1970, Calendar.MAY, 29), 0, "00000000000"));
        citizenPlayerService.add(new CitizenPlayer(3, 3, "Steven", "Rogers", LocalDate.of(1918, Calendar.JULY, 4), 0, "00000000000"));

        genreService.add(new Genre(1, "Action"));
        genreService.add(new Genre(2, "Sports"));
        genreService.add(new Genre(3, "Strategy"));
        genreService.add(new Genre(4, "Simulation"));

        platformService.add(new Platform(1, "PC"));
        platformService.add(new Platform(2, "XBOX One S"));
        platformService.add(new Platform(3, "Playstation 4"));
        platformService.add(new Platform(4, "Playstation 5"));
        platformService.add(new Platform(5, "XBOX Series X"));

        discountRatioService.add(new DiscountRatio(1, "Yeni Uye Indirimi", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 15));
        discountRatioService.add(new DiscountRatio(2, "Eskik Uye Indirimi", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 18));

        gameService.add(new Game(1, 3, 1, "BattleField 1", 20, 60));
        gameService.add(new Game(2, 4, 2, "ePES 2021", 60, 450));
        gameService.add(new Game(3, 1, 4, "Sims 4", 90, 86));

        // let's run four hundred lines of cirkin code
        menu(userService, citizenPlayerService, gameService, discountRatioService, platformService, genreService, shoppingCartService);
    }


    // here starts another cirkin code
    private static void menu(UserService userService, CitizenPlayerService citizenPlayerService, GameService gameService, DiscountRatioService discountRatioService, PlatformService platformService, GenreService genreService, ShoppingCartService shoppingCartService) throws Exception {
        String mainOption;
        do {
            System.out.println("----------Menu----------");
            System.out.println("1. Uye islemleri");
            System.out.println("2. Kampanya islemleri");
            System.out.println("3. Oyun islemleri");
            System.out.println("4. Oyuncu islemleri");
            System.out.println("5. Satin alma islemleri");
            System.out.println("0. Cikis");

            System.out.print("Lutfen devam etmek istediginiz secenegi girin: ");
            Scanner scanner = new Scanner(System.in);
            mainOption = scanner.nextLine();

            switch (mainOption) {
                case "1" -> {
                    System.out.println("----------Uye Islemleri----------");
                    System.out.println("1. Yeni uye olusturma");
                    System.out.println("2. Uye bilgilerini guncellleme");
                    System.out.println("3. Uye kaydini silme");
                    System.out.println("4. Id ile uye arama");
                    System.out.println("5. Tum uyeleri gosterme");
                    System.out.println("0. Bir ust menuye donus");
                    System.out.print("Lutfen devam etmek istediginiz secenegi girin: ");
                    var userOption = scanner.nextLine();
                    switch (userOption) {
                        case "1" -> {
                            System.out.println("----------Yeni Uye Olusturma----------");
                            System.out.print("Email adresi girin: ");
                            String email = scanner.nextLine();
                            System.out.print("Parola girin: ");
                            String password = scanner.nextLine();
                            int nextId = userService.getAll().size();
                            userService.add(new User(nextId, email, password));
                        }

                        case "2" -> {
                            System.out.println("----------Uye Bilgilerini Guncelleme----------");
                            System.out.print("Degistirmek istediginiz uyenin Id numarasini girin: ");
                            var userToUpdate = scanner.nextLine();
                            System.out.print("Yeni email adresi girin: ");
                            String emailToUpdate = scanner.nextLine();
                            System.out.print("Yeni parolayi girin: ");
                            String passwordToUpdate = scanner.nextLine();
                            userService.update(new User(Integer.parseInt(userToUpdate), emailToUpdate, passwordToUpdate));
                        }

                        case "3" -> {
                            System.out.println("----------Uye Kaydini Silme----------");
                            System.out.print("Silmek istedinigiz uyenin Id numarasini girin: ");
                            String userToDelete = scanner.nextLine();
                            userService.delete(userService.getById(Integer.parseInt(userToDelete)));
                        }

                        case "4" -> {
                            System.out.println("----------Id Ile Uye Arama----------");
                            System.out.print("Aramak istediginiz uyenin Id numarasini girin: ");
                            String userTofind = scanner.nextLine();
                            System.out.println(userService.getById(Integer.parseInt(userTofind)));
                        }

                        case "5" -> {
                            System.out.println("----------Tum Uyeleri Gosterme----------");
                            for (var user : userService.getAll()) {
                                System.out.println(user.getId() + " " + user.getEmail());
                            }
                        }

                        case "0" -> {
                        }
                    }
                }
                case "2" -> {
                    System.out.println("----------Kampanya Islemleri----------");
                    System.out.println("1. Yeni kampanya olusturma");
                    System.out.println("2. Kampanya bilgilerini guncellleme");
                    System.out.println("3. Kampanya kaydini silme");
                    System.out.println("4. Id ile kampanya arama");
                    System.out.println("5. Tum kampanyalari gosterme");
                    System.out.println("0. Bir ust menuye donus");
                    System.out.print("Lutfen devam etmek istediginiz secenegi girin: ");
                    var saleOption = scanner.nextLine();
                    switch (saleOption) {
                        case "1" -> {
                            System.out.println("----------Yeni Kampanya Olusturma----------");
                            DiscountRatio discountRatioToAdd = new DiscountRatio();
                            List<Integer> appliedToPlatforms = new ArrayList<>();
                            List<Integer> appliedToGenres = new ArrayList<>();
                            List<Integer> appliedToGames = new ArrayList<>();
                            discountRatioToAdd.setId(discountRatioService.getAll().size());
                            System.out.println("Degistirilecek kampanya Id numarasini girin");
                            System.out.print("Kampanya adini girin: ");
                            discountRatioToAdd.setName(scanner.nextLine());
                            System.out.print("Indirim oranini girin: ");
                            discountRatioToAdd.setRatio(Double.parseDouble(scanner.nextLine()));
                            System.out.print("Hangi oyunlarda gecerli oldugunu aralarinda sadece virgul olacak sekilde girin: ");
                            for (var appliedToGame : scanner.nextLine().split(",")) {
                                appliedToGames.add(Integer.parseInt(appliedToGame));
                            }
                            discountRatioToAdd.setAppliedToGames(appliedToGames);
                            System.out.print("Hangi turlerde gecerli oldugunu aralarinda sadece virgul olacak sekilde girin: ");
                            for (var appliedToGenre : scanner.nextLine().split(",")) {
                                appliedToGenres.add(Integer.parseInt(appliedToGenre));
                            }
                            discountRatioToAdd.setAppliedToGenres(appliedToGenres);
                            System.out.print("Hangi platformlara gecerli oldugunu aralarinda sadece virgul olacak sekilde girin: ");
                            for (var appliedToPlatform : scanner.nextLine().split(",")) {
                                appliedToPlatforms.add(Integer.parseInt(appliedToPlatform));
                            }
                            discountRatioToAdd.setAppliedToPlatforms(appliedToPlatforms);

                            discountRatioService.add(discountRatioToAdd);
                        }

                        case "2" -> {
                            System.out.println("----------Kampanya Bilgilerini Guncellleme----------");
                            DiscountRatio discountRatioToUpdate = new DiscountRatio();
                            List<Integer> appliedToPlatformsToUpdate = new ArrayList<>();
                            List<Integer> appliedToGenresToUpdate = new ArrayList<>();
                            List<Integer> appliedToGamesToUpdate = new ArrayList<>();
                            System.out.println("Degistirilecek kampanya Id numarasini girin");
                            discountRatioToUpdate.setId(Integer.parseInt(scanner.nextLine()));
                            System.out.print("Kampanya adini girin: ");
                            discountRatioToUpdate.setName(scanner.nextLine());
                            System.out.print("Indirim oranini girin: ");
                            discountRatioToUpdate.setRatio(Double.parseDouble(scanner.nextLine()));
                            for (var appliedToGame : scanner.nextLine().split(",")) {
                                appliedToGamesToUpdate.add(Integer.parseInt(appliedToGame));
                            }
                            discountRatioToUpdate.setAppliedToGames(appliedToGamesToUpdate);
                            for (var appliedToGenre : scanner.nextLine().split(",")) {
                                appliedToGenresToUpdate.add(Integer.parseInt(appliedToGenre));
                            }
                            discountRatioToUpdate.setAppliedToGenres(appliedToGenresToUpdate);
                            for (var appliedToPlatform : scanner.nextLine().split(",")) {
                                appliedToPlatformsToUpdate.add(Integer.parseInt(appliedToPlatform));
                            }
                            discountRatioToUpdate.setAppliedToPlatforms(appliedToPlatformsToUpdate);

                            discountRatioService.update(discountRatioToUpdate);
                        }

                        case "3" -> {
                            System.out.println("----------Kampanya Kaydini Silme----------");
                            System.out.print("Kaydini silecegini kampanyanin Id numarasini girin: ");
                            discountRatioService.delete(discountRatioService.getById(Integer.parseInt(scanner.nextLine())));
                        }

                        case "4" -> {
                            System.out.println("----------Id Ile Kampanya Arama----------");
                            System.out.print("Aramak istediginiz kampanyanin Id numarasini girin: ");
                            discountRatioService.getById(Integer.parseInt(scanner.nextLine()));
                        }

                        case "5" -> {
                            System.out.println("----------Tum Kampanyalari Gosterme----------");
                            for (var discountRatio : discountRatioService.getAll()) {
                                System.out.println(discountRatio.getId() + " " + discountRatio.getName());
                            }
                        }

                        case "0" -> {
                        }
                    }
                }
                case "3" -> {
                    System.out.println("----------Oyun Islemleri----------");
                    System.out.println("1. Yeni oyun olusturma");
                    System.out.println("2. Oyun bilgilerini guncellleme");
                    System.out.println("3. Oyun kaydini silme");
                    System.out.println("4. Id ile oyun arama");
                    System.out.println("5. Tum oyunlari gosterme");
                    System.out.println("6. Tum platformlari gosterme");
                    System.out.println("7. Tum turleri gosterme");
                    System.out.println("0. Bir ust menuye donus");
                    System.out.print("Lutfen devam etmek istediginiz secenegi girin: ");
                    var gameOption = scanner.nextLine();
                    switch (gameOption) {
                        case "1" -> {
                            System.out.println("----------Yeni Oyun Olusturma----------");
                            System.out.print("Oyunun ismini girin");
                            String name = scanner.nextLine();
                            System.out.print("Stok adedini girin: ");
                            String unitsInStock = scanner.nextLine();
                            System.out.print("Birim fiyatini girin: ");
                            String unitPrice = scanner.nextLine();
                            System.out.print("Turun Id numarasini girin: ");
                            String genre = scanner.nextLine();
                            System.out.print("Platform numarasini girin");
                            String platform = scanner.nextLine();
                            gameService.add(new Game(gameService.getAll().size(), Integer.parseInt(platform), Integer.parseInt(genre), name, Double.parseDouble(unitPrice), Integer.parseInt(unitsInStock)));

                        }
                        case "2" -> {
                            System.out.println("----------Oyun Bilgilerini Guncellleme----------");
                            System.out.print("Degistirmek istediginiz oyunun Id numarasini girin: ");
                            String gameToUpdate = scanner.nextLine();
                            System.out.print("Oyunun ismini girin: ");
                            String nameToUpdate = scanner.nextLine();
                            System.out.print("Stok adedini girin: ");
                            String unitsInStockToUpdate = scanner.nextLine();
                            System.out.print("Birim fiyatini girin: ");
                            String unitPriceToUpdate = scanner.nextLine();
                            System.out.print("Turun Id numarasini girin: ");
                            String genreToUpdate = scanner.nextLine();
                            System.out.print("Platform numarasini girin");
                            String platformToUpdate = scanner.nextLine();
                            gameService.update(new Game(Integer.parseInt(gameToUpdate), Integer.parseInt(platformToUpdate), Integer.parseInt(genreToUpdate), nameToUpdate, Double.parseDouble(unitPriceToUpdate), Integer.parseInt(unitsInStockToUpdate)));
                        }

                        case "3" -> {
                            System.out.println("----------Oyun Kaydini Silme----------");
                            System.out.print("Silmek istediginiz oyunun Id numarasini girin: ");
                            gameService.delete(gameService.getById(Integer.parseInt(scanner.nextLine())));

                        }
                        case "4" -> {
                            System.out.println("----------Id Ile Oyun Arama----------");
                            System.out.print("Aramak istediginiz oyunun Id numarasini girin: ");
                            System.out.println(gameService.getById(Integer.parseInt(scanner.nextLine())).getName());

                        }
                        case "5" -> {
                            System.out.println("----------Tum Oyunlari Gosterme----------");
                            for (var game : gameService.getAll()) {
                                System.out.println(game.getId() + " " + game.getName());
                            }
                        }

                        case "6" -> {
                            System.out.println("----------Tum Platformlari Gosterme----------");
                            for (var platform : platformService.getAll()) {
                                System.out.println(platform.getId() + " " + platform.getName());
                            }
                        }

                        case "7" -> {
                            System.out.println("----------Tum Turleri Gosterme----------");
                            for (var genre : genreService.getAll()) {
                                System.out.println(genre.getId() + " " + genre.getName());
                            }
                        }

                        case "0" -> {
                        }
                    }
                }

                case "4" -> {
                    System.out.println("----------Oyuncu Islemleri----------");
                    System.out.println("1. Yeni oyuncu olusturma");
                    System.out.println("2. Oyuncu bilgilerini guncellleme");
                    System.out.println("3. Oyuncu kaydini silme");
                    System.out.println("4. Id ile oyuncu arama");
                    System.out.println("5. Tum oyunculari gosterme");
                    System.out.println("0. Bir ust menuye donus");
                    System.out.print("Lutfen devam etmek istediginiz secenegi girin: ");
                    var playerOption = scanner.nextLine();
                    switch (playerOption) {
                        case "1" -> {
                            System.out.println("----------Yeni Oyuncu Olusturma----------");
                            System.out.print("Isim girin: ");
                            String firstName = scanner.nextLine();
                            System.out.print("Soyisim girin: ");
                            String lastName = scanner.nextLine();
                            System.out.print("Kullanici Id girin: ");
                            String userId = scanner.nextLine();
                            System.out.print("Dogum gununu yyyy-aa-gg formatinda girin: ");
                            String dateOfBirth = scanner.nextLine();
                            System.out.print("TC Kimlik no girin: ");
                            String nationalityId = scanner.nextLine();
                            citizenPlayerService.add(new CitizenPlayer(citizenPlayerService.getAll().size(), Integer.parseInt(userId), firstName, lastName, LocalDate.parse(dateOfBirth), 0, nationalityId));
                        }

                        case "2" -> {
                            System.out.println("----------Oyuncu Bilgilerini Guncellleme----------");
                            System.out.print("Degistirmek istediginiz oyuncunun Id numarasini girin: ");
                            String playerIdToUpdate = scanner.nextLine();
                            System.out.print("Isim girin: ");
                            String firstNameToUpdate = scanner.nextLine();
                            System.out.print("Soyisim girin: ");
                            String lastNameToUpdate = scanner.nextLine();
                            System.out.print("Kullanici Id girin: ");
                            String userIdToUpdate = scanner.nextLine();
                            System.out.print("Dogum gununu yyyy-aa-gg formatinda girin: ");
                            String dateOfBirthToUpdate = scanner.nextLine();
                            System.out.print("TC Kimlik no girin: ");
                            String nationalityIdToUpdate = scanner.nextLine();
                            citizenPlayerService.update(new CitizenPlayer(Integer.parseInt(playerIdToUpdate), Integer.parseInt(userIdToUpdate), firstNameToUpdate, lastNameToUpdate, LocalDate.parse(dateOfBirthToUpdate), 0, nationalityIdToUpdate));
                        }

                        case "3" -> {
                            System.out.println("----------Oyuncu Kaydini Silme----------");
                            System.out.print("Silmek istediginiz oyuncunun Id numarasini girin: ");
                            citizenPlayerService.delete(citizenPlayerService.getById(Integer.parseInt(scanner.nextLine())));
                        }

                        case "4" -> {
                            System.out.println("----------Id Ile Oyuncu Arama----------");
                            System.out.print("Aramak istediginiz oyuncunun Id numarasini girin: ");
                            System.out.println(citizenPlayerService.getById(Integer.parseInt(scanner.nextLine())).getFullName());
                        }

                        case "5" -> {
                            System.out.println("----------Tum Oyunculari Gosterme----------");
                            for (var citizenPlayer : citizenPlayerService.getAll()) {
                                System.out.println(citizenPlayer.getId() + " " + citizenPlayer.getFullName());
                            }
                        }

                        case "0" -> {
                        }
                    }
                }

                case "5" -> {
                    System.out.println("----------Satin Alma Islemleri----------");
                    System.out.println("1. Yeni sepet olusturma");
                    System.out.println("2. Sepet bilgilerini guncellleme");
                    System.out.println("3. Sepet kaydini silme");
                    System.out.println("4. Id ile sepet arama");
                    System.out.println("5. Tum sepetleri gosterme");
                    System.out.println("0. Bir ust menuye donus");
                    System.out.print("Lutfen devam etmek istediginiz secenegi girin: ");
                    var shoppingCartOption = scanner.nextLine();

                    switch (shoppingCartOption) {
                        case "1" -> {
                            System.out.println("----------Yeni Sepet Olusturma----------");
                            System.out.print("Kullanicinin Id numarasi: ");
                            CitizenPlayer player = citizenPlayerService.getById(Integer.parseInt(scanner.nextLine()));
                            System.out.print("Sepete eklemek istediginiz oyunlarin Id numarasini sadece virgul ile ayirarak yazin");
                            List<Game> gamesList = new ArrayList<>();
                            for (var game : scanner.nextLine().split(",")) {
                                gamesList.add(gameService.getById(Integer.parseInt(game)));
                            }
                            System.out.print("Indirim turunun Id numarasini girin");
                            String discountRatio = scanner.nextLine();
                            shoppingCartService.add(new ShoppingCart(shoppingCartService.getAll().size(), gamesList, player, discountRatioService.getById(Integer.parseInt(discountRatio))));
                        }

                        case "2" -> {
                            System.out.println("----------Sepet Bilgilerini guncelleme----------");
                            System.out.print("Guncellemek istediginiz sepet Id numarasini girin: ");
                            String shoppingCartToUpdate = scanner.nextLine();
                            System.out.print("Kullanicinin Id numarasi: ");
                            CitizenPlayer playerToUpdate = citizenPlayerService.getById(Integer.parseInt(scanner.nextLine()));
                            System.out.print("Sepete eklemek istediginiz oyunlarin Id numarasini sadece virgul ile ayirarak yazin: ");
                            List<Game> gamesListToUpdate = new ArrayList<>();
                            for (var game : scanner.nextLine().split(",")) {
                                gamesListToUpdate.add(gameService.getById(Integer.parseInt(game)));
                            }
                            System.out.print("Indirim turunun Id numarasini girin");
                            String discountRatio = scanner.nextLine();
                            shoppingCartService.add(new ShoppingCart(Integer.parseInt(shoppingCartToUpdate), gamesListToUpdate, playerToUpdate, discountRatioService.getById(Integer.parseInt(discountRatio))));
                        }

                        case "3" -> {
                            System.out.println("----------Sepet Kaydini Silme----------");
                            System.out.print("Silmek istediginiz sepet Id numarasini girin: ");
                            shoppingCartService.delete(shoppingCartService.getById(Integer.parseInt(scanner.nextLine())));
                        }
                        case "4" -> {
                            System.out.println("----------Id Ile Sepet Arama----------");
                            System.out.print("Aramak istediginiz sepetin Id numarasini girin: ");
                            System.out.println(shoppingCartService.getById(Integer.parseInt(scanner.nextLine())).getId());
                        }
                        case "5" -> {
                            System.out.println("----------Tum Sepetleri Gosterme----------");
                            for (var shoppingCart : shoppingCartService.getAll()) {
                                System.out.println(shoppingCart.getId() + " " + shoppingCart.getPlayer().getFullName());
                            }
                        }

                        case "0" -> {

                        }
                    }
                }

                case "0" -> System.out.println("Cikis yapiliyor...");
            }
        } while (!mainOption.equals("0"));
    }
}
