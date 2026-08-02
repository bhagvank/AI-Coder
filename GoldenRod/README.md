# GoldenRod

GoldenRod is a multi-target **code generation engine** that produces CRUD application layers from entity metadata. Written in Java, it emits source files for Java (JDBC), PHP (PDO), AngularJS front ends, and Django project scaffolding.

Part of the [AI-Coder](../README.md) project.

## Features

- **Java stack** — POJO, JDBC DAO, and BusinessDelegate service layer
- **PHP stack** — POJO classes and PDO data-access objects
- **AngularJS stack** — List, create, edit, and delete HTML pages with `$http` JSON calls to PHP endpoints
- **Django scaffold** — `settings.py`, `views.py`, and `urls.py` generation
- **Metadata-driven** — Entity name, ID field, columns, and member types drive all outputs
- **Template-based** — Composable Java templates assemble target-language source as strings

## Project Structure

```
GoldenRod/
├── src/org/archcorner/codegen/   # Generator engine (Java)
│   ├── java/                     # JDBC generation
│   ├── php/                      # PHP generation
│   ├── angular/                  # AngularJS HTML generation
│   │   └── webservices/php/      # PHP backend for Angular views
│   └── django/                   # Django scaffolding
├── bin/                          # Compiled generator classes
├── java/                         # Generated Java output (Partner example)
├── php/                          # Generated PHP output (Customer, Partner)
├── angular/                      # Generated AngularJS views
└── mysite/                       # Generated Django project shell
```

## Generated Output (Examples)

This repository includes sample output for two entities:

| Entity | Java | PHP | Angular |
|--------|------|-----|---------|
| **Partner** | `Partner.java`, `PartnerDAO.java`, `PartnerBusinessDelegate.java` | `Partner.php` | — |
| **Customer** | — | `Customer.php`, `CustomerPDO.php` | `Customers.html`, `CustomerForm.html`, `EditCustomerForm.html`, `DeleteCustomerForm.html` |

### Java (Partner)

Three-tier JDBC pattern:

```
BusinessDelegate → DAO → JDBCManager → Database
```

### PHP (Customer)

PDO data access extending a shared `DataObject` base class:

```
CustomerPDO → DataObject → Database
```

### AngularJS (Customer)

Four pages per entity, calling PHP REST endpoints via `$http`:

| Page | Endpoint | Action |
|------|----------|--------|
| `Customers.html` | GET `Customers.php` | List |
| `CustomerForm.html` | POST `InsertCustomer.php` | Create |
| `EditCustomerForm.html` | POST `GetCustomer.php` / `UpdateCustomer.php` | Edit |
| `DeleteCustomerForm.html` | POST `DeleteCustomer.php` | Delete |

## Prerequisites

- **Java JDK** — to compile and run the generator
- **Eclipse IDE** (optional) — project includes `.project` / `.classpath`
- **PHP + PDO** — to run generated PHP/Angular backend
- **Python + Django** — to run the generated `mysite` scaffold
- **Database** — MySQL or compatible DB for generated CRUD code

## Quick Start

### 1. Build the generator

Open the project in Eclipse and build, or compile manually:

```bash
cd GoldenRod
javac -d bin -sourcepath src src/org/archcorner/codegen/**/*.java
```

> **Note:** Java sources under `src/org/archcorner/codegen/` may need to be restored from git history if the directory is empty. Compiled classes are available in `bin/`.

### 2. Run a generator

From the GoldenRod project root:

```bash
# Java POJO + DAO + BusinessDelegate
java -cp bin org.archcorner.codegen.java.CodeGenerator

# PHP POJO + PDO
java -cp bin org.archcorner.codegen.php.CodeGenerator

# AngularJS HTML pages
java -cp bin org.archcorner.codegen.angular.HTMLTemplate

# PHP backend for Angular
java -cp bin org.archcorner.codegen.angular.webservices.php.CodeGenerator

# Django scaffold
java -cp bin org.archcorner.codegen.django.CodeGenerator
```

Each `main()` method uses hard-coded Partner/Customer metadata as a demo. Customize the entity lists in the source before running, or extend the entry points to accept CLI arguments.

### 3. Entity metadata

All CRUD generators accept the same core inputs:

```java
String entity = "Partner";
String idEntity = "PartnerId";
String nameEntity = "PartnerName";
List<String> entityColumns = List.of("PARTNERNAME", "PARTNERADDRESS", ...);
List<String> pojoMembers = List.of("partnerName", "partnerAddress", ...);
List<String> types = List.of("int", "String", "String", ...);
```

## Documentation

| Document | Description |
|----------|-------------|
| [ARCHITECTURE.md](ARCHITECTURE.md) | System context, layer design, and stack overviews |
| [TECHNICAL_DESIGN.md](TECHNICAL_DESIGN.md) | Class responsibilities, generation algorithms, and extension points |

## External Dependencies

Generated code references libraries not included in this repo:

| Dependency | Used by |
|------------|---------|
| `org.archcorner.chartreuse` (`JDBCManager`, POJO/DAO packages) | Generated Java DAO and BusinessDelegate |
| `DataObject.php` | Generated PHP PDO classes |
| AngularJS 1.2.1 (CDN) | Generated HTML views |

## License

See the [AI-Coder](../README.md) repository for license information.
