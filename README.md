# antlr4-parsers-lab

Lexers and parsers built with ANTLR4 and Java for three languages: CSV files, **E++** (a small Spanish-keyword programming language) and a domain-specific language for **IKEA furniture assembly instructions**. Each parser builds the syntax tree, which can be shown graphically or exported as indented text.

Lab project (PL2) for the *Procesadores del Lenguaje* (Language Processors) course at the University of Alcalá (UAH), 2025–26 academic year. The E++ and CSV grammars are extended into a full compiler in [epp-compiler-jasmin](https://github.com/crest4s/epp-compiler-jasmin).

## Languages

| Grammar | Description | Program |
|---------|-------------|---------|
| `csv/CSV.g4` | CSV with `,`, `;` or `\|` separators, quoted, unquoted and empty fields, escaped quotes (`""`) | `csv.CSVMain` |
| `epp/EPP.g4` | E++: assignments, input/output, conditionals, loops, comments, arithmetic and boolean expressions | `epp.EPPMain` |
| `ikea/IKEA.g4` | Assembly manuals: numbered steps with actions (insert, screw, join, mark, nail, slide...), parts, fittings with their codes and tools | `ikea.IkeaMain` |

Example of an IKEA manual (`archivos-prueba/muebles-ikea-instrucciones/BILLY.txt`):

```
ITEM:BILLY
1-Insertar 16 espigas 101531 en pieza embellecedor y 3 piezas balda.
2-Con destornillador, atornillar 12 tornillos 118331 en 2 piezas lateral.
3-Unir pieza embellecedor y pieza lateral; Unir 2 piezas balda y pieza lateral.
```

For the IKEA language, `ikea.Analyzer` walks the tree with a visitor and builds a symbol table with the fittings and tools, showing the actions, fittings and tools used in each step and in total.

## Structure

```
proyecto/                 # Gradle project
├── src/main/antlr/       # grammars (csv, epp, ikea)
└── src/main/java/        # main programs, AST generators and the IKEA analyzer
archivos-prueba/          # sample inputs: CSV files, E++ programs and 13 IKEA manuals
ast-generado/             # generated syntax trees (SVG and text) for the sample inputs
```

## Build and run

Requirements: JDK 17 or later. The Gradle wrapper downloads Gradle and ANTLR, and the parsers are generated at build time.

```bash
cd proyecto
./gradlew build
./gradlew run -q --console=plain                            # CSV parser
./gradlew run -q --console=plain -PmainClass=epp.EPPMain    # E++ parser
./gradlew run -q --console=plain -PmainClass=ikea.IkeaMain  # IKEA manuals
```

Each program asks for an input file (for example `../archivos-prueba/CSV_01.txt`) and then lets you show the tree graphically, export it as text or change the file; type `exit` to quit.

## Authors

- Adrián Morales Rodríguez ([@crest4s](https://github.com/crest4s))
- [@aliciasiguenza](https://github.com/aliciasiguenza)
- [@avuren13](https://github.com/avuren13)
