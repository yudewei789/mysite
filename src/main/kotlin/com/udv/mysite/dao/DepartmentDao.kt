package com.udv.mysite.dao

import com.udv.mysite.model.Department
import com.udv.mysite.model.Departments
import org.springframework.stereotype.Component

/**
 * Created by vince on Jun 15, 2022.
 */
@Component
class DepartmentDao : BaseDao<Department, Departments>(Departments)
