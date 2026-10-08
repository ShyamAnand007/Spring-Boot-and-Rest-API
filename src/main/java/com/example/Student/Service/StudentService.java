package com.example.Student.aservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Student.Bean.Student;
import com.example.Student.Dao.StudentDao;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    // Register a new student
    public Student registerStudent(Student student) {
        return studentDao.save(student);
    }

    // Get student by ID
    public Student getStudentById(Long id) {
        return studentDao.findById(id).orElse(null);
    }

    // Delete student by ID
    public void deleteStudent(Long id) {
        studentDao.deleteById(id);
    }

    // Update student
    public Student updateStudent(Long id, Student updatedStudent) {
        return studentDao.findById(id).map(student -> {

            student.setFirstName(updatedStudent.getFirstName());
            student.setLastName(updatedStudent.getLastName());
            student.setAge(updatedStudent.getAge());
            student.setGender(updatedStudent.getGender());
            student.setPhone(updatedStudent.getPhone());
            student.setEmail(updatedStudent.getEmail());
            student.setAddress(updatedStudent.getAddress());
            student.setEmergencyContact(updatedStudent.getEmergencyContact());

            return studentDao.save(student);

        }).orElse(null);
    }

    // Get all students
    public Iterable<Student> getAllStudents() {
        return studentDao.findAll();
    }

    // Find student by email
    public Student findByEmail(String email) {
        return studentDao.findByEmail(email).orElse(null);
    }
}