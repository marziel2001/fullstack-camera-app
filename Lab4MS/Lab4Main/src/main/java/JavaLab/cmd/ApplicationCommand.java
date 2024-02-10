package JavaLab.cmd;

import JavaLab.camera.entity.Brand;
import JavaLab.camera.entity.Model;
import JavaLab.camera.service.api.BrandService;
import JavaLab.camera.service.api.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.UUID;

@Component
public class ApplicationCommand implements CommandLineRunner {

    private final BrandService service;

    private final ModelService modelService;

    @Autowired
    public ApplicationCommand(BrandService service, ModelService modelService)
    {
        this.service = service;
        this.modelService = modelService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String command;

        boolean loop = true;

        while(loop) {

            System.out.println("\nAvailable commands:\n" +
                "get_brands - lists all brands\n" +
                "get_models - lists all models from all brands\n" +
                "delete_model\n" +
                "delete_brand\n" +
                "add_model - lets create new model under the existing brand\n" +
                "add_brand - lets create new brand\n" +
                "quit - to quit the app\n"
            );

            command = scanner.nextLine();
            switch (command) {
                case "get_brands" -> {
                    service.listAll().forEach(System.out::println);
                }
                case "get_models" -> {
                    modelService.listAll().forEach(System.out::println);
                }
                case "delete_model" -> {
                    System.out.println("please provide brand name:");
                    String brandName = scanner.nextLine();
                    System.out.println("brand name:" + brandName);

                    System.out.println("please provide model name:");
                    String modelName = scanner.nextLine();
                    System.out.println("model: " + modelName);

                    modelService.deleteModel(brandName, modelName);

                    modelService.listAll().forEach(System.out::println);
                }
                case "delete_brand" -> {
                    System.out.println("please provide brand name");
                    String brandName = scanner.nextLine();
                    System.out.println("brand name:" + brandName);

                    service.delete(brandName);
                }
                case "add_model" -> {
                    System.out.println("please provide brand name");
                    String brandName = scanner.nextLine();
                    System.out.println("brand: "+brandName);

                    System.out.println("please provide name:");
                    String name = scanner.nextLine();
                    System.out.println("name: "+name);

                    System.out.println("please provide price [9999,99]:");
                    Double price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("price: "+price);

                    System.out.println("please provide year:");
                    Integer year = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("year:"+year);

                    modelService.addModelToBrand(brandName,
                        Model.builder()
                        .uuid(UUID.randomUUID())
                        .name(name)
                        .price(price)
                        .announceYear(year)
                        .build()
                    );

                    modelService.listAll().forEach(System.out::println);
                }
                case "add_brand" -> {

                    System.out.println("please provide uuid:");
                    String uuid = scanner.nextLine();
                    System.out.println("uuid: " + uuid);

                    System.out.println("please provide brand name");
                    String brandName = scanner.nextLine();
                    System.out.println("brand:"+brandName);

                    System.out.println("please provide year of establishment:");
                    Integer year = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("year:"+year);

                    System.out.println("please provide country:");
                    String country = scanner.nextLine();
                    System.out.println("country: " + country);

                    System.out.println("please provide price [9999,99]:");
                    Double value = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("price:"+value);

                    service.create(Brand.builder()
                        .uuid(UUID.randomUUID())
                        .name(brandName)
                        .yearOfEst(year)
                        .country(country)
                        .brandValueDollars(value)
                        .build()
                    );

                }
                case "quit" -> loop = false;
            }
        }
    }
}
