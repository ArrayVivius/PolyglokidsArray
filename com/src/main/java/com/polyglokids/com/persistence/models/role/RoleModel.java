// package com.polyglokids.com.persistence.models.role;
//
// import jakarta.persistence.CollectionTable;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.Column;
// import jakarta.persistence.ElementCollection;
// import jakarta.persistence.Entity;
// import jakarta.persistence.EnumType;
// import jakarta.persistence.Enumerated;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;
//
// /**
// * RoleModel
// */
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// @Entity
// @Table(name = "roles")
// public class RoleModel {
// @Id
// @Column(name = "id_role")
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// private String id;
//
// @Column(name = "role_name", nullable = false)
// @Enumerated(EnumType.STRING)
// private ERoleType name;
//
// }
