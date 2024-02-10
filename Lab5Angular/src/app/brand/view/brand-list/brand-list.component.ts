import {Component, OnInit} from '@angular/core';
import {BrandService} from "../../service/brand.service";
import {Brands} from "../../model/brands";
import {Brand} from "../../model/brand";

@Component({
  selector: 'app-brand-list',
  templateUrl: './brand-list.component.html',
  styleUrls: ['./brand-list.component.css', '../../../tables.css']
})
export class BrandListComponent implements OnInit {

  constructor(private service: BrandService) {
  }

  brands: Brands | undefined;

  ngOnInit(): void {
    this.service.getBrands().subscribe(brands => this.brands = brands);
  }

  onDelete(brand: Brand): void {
    this.service.deleteBrand(brand.id).subscribe(() => this.ngOnInit());
  }
}
