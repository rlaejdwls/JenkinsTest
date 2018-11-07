package com.example.demo.common.repository

import com.example.demo.common.entity.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository interface UserRepository: CrudRepository<User, Int>, UserDynamicQueryRepository {
    /**
     * 처음에는 select+어쩌구로 함수명을 지었었음, 인터페이스를 구현하는데가 없는데
     * Pageable 파라미터를 넘기면자동으로 페이징함수로 인식하는건가 의문이었는데 작동을안함
     * 아마 find가 약속된 접두사인듯 find By 어쩌구하면 검색 함수로 인식한다던가 그런 느낌?
     * 어노테이션 형태의 바인딩도 제공할거 같지만 아직 찾아보지는 않았음
     */
    fun findAll(pageable: Pageable): Page<User>
    /**
     * 어노테이션 형태의 쿼리 바인딩, mybatis처럼 동적으로 쿼리를 제어할 수 있다면 금상첨화일듯
     */
    @Query(value = "SELECT * FROM test_user LIMIT :offset, :size", nativeQuery = true)
    fun selectUserForPaging(@Param("offset") offset: Int, @Param("size") size: Int): Iterable<User>
}