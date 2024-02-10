import {Component, OnInit} from '@angular/core';
import {BrandDetails} from "../../model/brand-details";
import {BrandService} from "../../service/brand.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-brand-view',
  templateUrl: './brand-view.component.html',
  styleUrls: ['./brand-view.component.css', '../../../tables.css']
})
export class BrandViewComponent implements OnInit {

  brand: BrandDetails | undefined;

  constructor(
      private service: BrandService,
      private route: ActivatedRoute,
      private router: Router
  ) {
  }
  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.service.getBrand(params['uuid'])
          .subscribe(brand => this.brand = brand)
    })
  }

}
