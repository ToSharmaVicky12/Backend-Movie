package com.movies.specification;

import java.util.ArrayList;

import javax.persistence.criteria.Predicate;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.movies.dto.MovieFilter;
import com.movies.entity.Movies;
import com.movies.entity.Movies_;
import com.movies.utils.SpecificationUtils;

@Component
public class MovieSpecificationGenerator extends AuditableEntitySpecificationGenerator<Movies> {
	public Specification<Movies> byFilter(MovieFilter filter) {
		return (root, criteriaQuery, criteriaBuilder) -> {
			var predicates = new ArrayList<Predicate>();
			if (StringUtils.isNotEmpty(filter.getSearchText())) {

				predicates.add(criteriaBuilder.like(root.get(Movies_.title),
						SpecificationUtils.wrapWithWildcards(filter.getSearchText())));
			}
			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

		};

	}

	@Override
	protected Class<Movies> getEntityClass() {
		return Movies.class;
	}

}
