package guru.springfamework.repositories;

import guru.springfamework.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jt on 9/27/17.
 */
public interface VendorRepository extends JpaRepository<Vendor, Long>{
}
