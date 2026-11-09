### Premise

This project is inspired by many stories told about the solar system,
from snowball Earths, moons breaking up to form rings, to lost gas
giants ejected from the system. This project aims to simulate the
evolution of a star system, from start to end, allowing users to
witness eons of cosmic stories in the span of a few minutes.

The simulation is pseudoscientific; while it is inspired by some
ideas and theories of science, it does not aim to be scientifically
accurate. For example, while planets orbit around a star in a near-2D
plane, this simulation places them on a 1D axis because it only
considers the planets' semi-major axes.

### Simulation

(Unimplemented)
The system will provide a snapshot of itself and prompt the user to
simulate over a given time period. Snapshots are provided at the
very start of the simulation, as well as before the user decides to
run the simulation for a given amount of time. The user can decide
to either run the simulation for an eon, or end the program as is.

### StarSystem

Star systems consist of a central star, a protoplanetary disk, and a
variable number of planets. The elements making up this system are
lined up in a single axis: the distance to the central star.

### Protoplanetary Disk
Over time, planets can form from material in the
protoplanetary disk. Sections of the disk that have material are
eligible to form a planet, and sections with more material will
form a planet more quickly.

Over time, planets will collect material from the
protoplanetary disk. Mass from the disk will be transferred to the
planets, which means that the disk's mass will decrease. The planets
will take mass from different areas of the disk.

Over time, if there are discrepancies in the disk
(e.g. a hole in the disk), material in the disk will diffuse,
allowing the disk's material to smooth and spread out if planets
either take from the disk or give matter to the disk.

### Planet

A planet is a large, round celestial body. Planets differ by mass and
distance to the star. The star at the center of the star system is
also a "planet" since it is also a rounded celestial body with a
mass.

Over time, a planet will collect material from its
star system's protoplanetary disk. As the planet collects matter
from the disk, the location of the missing disk material will be
distributed so the planet doesn't take material from an exact in the
system. Larger planets will have a wider distribution of material
to collect from. They will also collect material faster; this will
be represented by the fraction of a disk section that a planet can
take at a given instance of time.

(Unimplemented)
Planets have names, allowing them to be tracked. These names are
pulled from a hardcoded list of pre-generated names.

(Unimplemented)
Planets exert forces on each other. Larger planets, having more mass,
are more resistant to gravitational pulls. Larger planets also exert
a more powerful and effective pull on neighboring planets. The pull
of a planet is less effective with distance. Given that planets may
never collide if they are far enough, there will be a limit where a
planet will not move at all if the net force on it is insufficient.

(Unimplemented)
When a force acts on a planet, the planet will move based on how much
orbital inertia it has. Orbital inertia determines how sensitive a
planet is to gravitational forces. A planet with more mass has more
orbital inertia. A planet that is closer to the star will also have
more inertia, given that more force may be needed to adjust high
orbital velocities near the star. A force pulling a planet away from
its star will decrease its orbital inertia, increasing its distance
from the star---and a force pulling the planet towards its star will
decrease its orbital inertia, decreasing its distance to the star.