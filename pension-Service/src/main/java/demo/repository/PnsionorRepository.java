package demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.entity.Pensionor;


public interface PnsionorRepository extends JpaRepository<Pensionor,Integer> 
{

}
