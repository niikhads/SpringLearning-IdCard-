package com.example.LearningSpring.Model.Dto.Response;

import java.util.Objects;

public class IdCardResponse {

    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private String finCode;
    private String series;
    private String serialNumber;

    public IdCardResponse(Long id,
                          String name,
                          String surname,
                          Integer age,
                          String finCode,
                          String series,
                          String serialNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.finCode = finCode;
        this.series = series;
        this.serialNumber = serialNumber;
    }

    public static IdCardBuilder builder() {
        return new IdCardBuilder();
    }

    public static class IdCardBuilder {
        private Long id;
        private String name;
        private String surname;
        private Integer age;
        private String finCode;
        private String series;
        private String serialNumber;

        public IdCardBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public IdCardBuilder name(String name) {
            this.name = name;
            return this;
        }

        public IdCardBuilder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public IdCardBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public IdCardBuilder finCode(String finCode) {
            this.finCode = finCode;
            return this;
        }

        public IdCardBuilder series(String series) {
            this.series = series;
            return this;
        }

        public IdCardBuilder serialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        public IdCardResponse build() {
            IdCardResponse idCard =
                    new IdCardResponse(
                            this.id,
                            this.name,
                            this.surname,
                            this.age,
                            this.finCode,
                            this.series,
                            this.serialNumber
                    );
            return idCard;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFinCode() {
        return finCode;
    }

    public void setFinCode(String finCode) {
        this.finCode = finCode;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdCardResponse idCard = (IdCardResponse) o;
        return id == idCard.id && age == idCard.age && Objects.equals(name, idCard.name) && Objects.equals(surname, idCard.surname) && Objects.equals(finCode, idCard.finCode) && Objects.equals(series, idCard.series) && Objects.equals(serialNumber, idCard.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, age, finCode, series, serialNumber);
    }

    @Override
    public String toString() {
        return "IdCardResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", finCode='" + finCode + '\'' +
                ", series='" + series + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                '}';
    }
}