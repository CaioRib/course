package com.caiorib.spring.course;

import com.caiorib.spring.course.domain.AddressEntity;
import com.caiorib.spring.course.domain.CardPaymentEntity;
import com.caiorib.spring.course.domain.CategoryEntity;
import com.caiorib.spring.course.domain.CityEntity;
import com.caiorib.spring.course.domain.CustomerEntity;
import com.caiorib.spring.course.domain.OrderEntity;
import com.caiorib.spring.course.domain.PaymentEntity;
import com.caiorib.spring.course.domain.ProductEntity;
import com.caiorib.spring.course.domain.SlipPaymentEntity;
import com.caiorib.spring.course.domain.StateEntity;
import com.caiorib.spring.course.domain.enums.CustomerTypeEnum;
import com.caiorib.spring.course.domain.enums.PaymentStatusEnum;
import com.caiorib.spring.course.repositories.AddressRepository;
import com.caiorib.spring.course.repositories.CategoryRepository;
import com.caiorib.spring.course.repositories.CityRepository;
import com.caiorib.spring.course.repositories.CustomerRepository;
import com.caiorib.spring.course.repositories.OrderRepository;
import com.caiorib.spring.course.repositories.PaymentRepository;
import com.caiorib.spring.course.repositories.ProductRepository;
import com.caiorib.spring.course.repositories.StateRepository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class Application {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private PaymentRepository paymentRepository;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	void startupDB() {
		CategoryEntity category1 = new CategoryEntity(null, "Informática");
		CategoryEntity category2 = new CategoryEntity(null, "Escritório");

		ProductEntity product1 = new ProductEntity(null, "Computador", "2000");
		ProductEntity product2 = new ProductEntity(null, "Impressora", "800");
		ProductEntity product3 = new ProductEntity(null, "Mouse", "80");

		category1.getProducts().addAll(Arrays.asList(product1, product2, product3));
		category2.getProducts().addAll(Arrays.asList(product2));

		product1.getCategories().add(category1);
		product2.getCategories().addAll(Arrays.asList(category1, category2));
		product3.getCategories().add(category1);

		StateEntity state1 = new StateEntity(null, "São Paulo");
		StateEntity state2 = new StateEntity(null, "Minas Gerais");

		CityEntity city1 = new CityEntity(null, "Uberlândia", state2);
		CityEntity city2 = new CityEntity(null, "São Paulo", state1);
		CityEntity city3 = new CityEntity(null, "Campinas", state1);


		state1.getCities().addAll(Arrays.asList(city2, city3));
		state2.getCities().add(city1);

		CustomerEntity customer1 = new CustomerEntity(null, "Maria Silva", "maria@gmail.com", "36378912377", CustomerTypeEnum.NATURAL_PERSON);
		customer1.getPhones().addAll(Arrays.asList("27363323", "93838393"));

		AddressEntity address1 = new AddressEntity(null, "Rua Flores", 300L, "Apto 303", "Jardim", "38220834", customer1, city1);
		AddressEntity address2 = new AddressEntity(null, "Ave Matos", 105L, "Sala 800", "Centro", "38777012", customer1, city2);

		customer1.getAddresses().addAll(Arrays.asList(address1, address2));

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		OrderEntity order1 = null;
		OrderEntity order2 = null;
		PaymentEntity payment1 = null;
		PaymentEntity payment2 = null;

		try {
			order1 = new OrderEntity(null, simpleDateFormat.parse("30/09/2017 10:32"), customer1, address1);
			order2 = new OrderEntity(null, simpleDateFormat.parse("10/10/2017 19:35"), customer1, address2);

			payment1 = new CardPaymentEntity(null, PaymentStatusEnum.FINISHED, order1, 6);
			order1.setPayment(payment1);

			payment2 = new SlipPaymentEntity(null, PaymentStatusEnum.PENDING, order2, simpleDateFormat.parse("20/10/2017 00:00"), null);
			order2.setPayment(payment2);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		customer1.getOrders().addAll(Arrays.asList(order1, order2));

		categoryRepository.saveAll(Arrays.asList(category1, category2));
		productRepository.saveAll(Arrays.asList(product1, product2, product3));
		stateRepository.saveAll(Arrays.asList(state1, state2));
		cityRepository.saveAll(Arrays.asList(city1, city2, city3));
		customerRepository.save(customer1);
		addressRepository.saveAll(Arrays.asList(address1, address2));
		orderRepository.saveAll(Arrays.asList(order1, order2));
		paymentRepository.saveAll(Arrays.asList(payment1, payment2));


	}

}
